package jentus.dictionary.service;

import jentus.dictionary.exception.CardNotFoundException;
import jentus.dictionary.model.*;
import jentus.dictionary.model.dto.CardWriterDto;
import jentus.dictionary.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final PartOfSpeechRepository partOfSpeechRepository;
    private final CardRepository cardRepository;
    private final SlotRepository slotRepository;
    private final CardAndSlotRepository cardAndSlotRepository;
    private final FileRepository fileRepository;
    private final CardEventRepository cardEventRepository;
    private final TranscriptionRepository transcriptionRepository;


    @Override
    @Transactional
    public void save(CardWriterDto cardWriterDto) {
        System.out.println(cardWriterDto);
        Card card = new Card();
        card.setPhotoId(UUID.fromString(cardWriterDto.getPhotoId()));
        card.setDefinition(cardWriterDto.getDefinition());
        card.setTranslate(cardWriterDto.getTranslate());
        card.setExpression(cardWriterDto.getExpression());
        partOfSpeechRepository.findById(cardWriterDto.getPartOfSpeechId()).ifPresent(card::setPartOfSpeech);
        card.setExamples(new HashSet<>());

        cardRepository.save(card);

        cardWriterDto.getExampleList().forEach(str -> {
            Example example = new Example();
            example.setCard(card);
            example.setText(str);
            card.getExamples().add(example);
        });

        card.setTranscriptions(new HashSet<>());
        cardWriterDto.getTranscriptionList().forEach(tr -> {
            Transcription transcription = new Transcription();
            transcription.setCard(card);
            transcription.setFileId(UUID.fromString(tr.getFileId()));
            transcription.setValue(tr.getValue());
            transcription.setVariant(tr.getVariant());
            card.getTranscriptions().add(transcription);
        });

        cardRepository.save(card);

        List<CardAndSlot> cardAndSlots = new ArrayList<>();
        slotRepository.findAllById(cardWriterDto.getSlotIds()).forEach(slot -> {
            CardAndSlot cardAndSlot = new CardAndSlot();
            cardAndSlot.setCard(card);
            cardAndSlot.setSlot(slot);
            cardAndSlots.add(cardAndSlot);
        });
        cardAndSlotRepository.saveAll(cardAndSlots);
    }

    @Override
    @Transactional
    public void repeatCard(Long cardId) {
        cardRepository.findById(cardId).ifPresent(card -> {
            CardEvent cardEvent = new CardEvent();
            cardEvent.setEventDate(new Date());
            cardEvent.setCard(card);
            cardEventRepository.save(cardEvent);
        });
    }

    @Override
    @Transactional
    public void deleteCard(Long cardId) {
        cardRepository.findById(cardId).ifPresent(card -> {
            card.getTranscriptions().forEach(transcription -> {
                String fileId = transcription.getFileId() != null ? transcription.getFileId().toString() : null;
                if (fileId != null) {
                    fileRepository.delete(fileId);
                }
                //transcriptionRepository.deleteById(transcription.getId());
            });
            cardAndSlotRepository.removeByCardId(cardId);
            cardRepository.delete(card);
        });
    }

    @Override
    public List<Card> getAllBySlotId(Long slotId, Pageable pageable) {
        return cardRepository.findAllBySlotId(slotId, pageable);
    }

    @Override
    public List<Card> getStudentCardsBySlotId(Long slotId, int limit) {
        List<Long> ids = cardRepository.findStudentIds(slotId);
        if (ids != null && ids.size() > 0) {
            List<Card> cards = cardRepository.findStudentCardByIds(ids, PageRequest.of(0, limit));
            if (cards != null && cards.size() < limit) {
                List<Card> cardsAddon = cardRepository.findStudentNewCardsBySlotId(slotId, PageRequest.of(0, limit - cards.size()));
                cards.addAll(cardsAddon);
            }
            return cards;
        }
        return new ArrayList<>();
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow(CardNotFoundException::new);
    }
}
