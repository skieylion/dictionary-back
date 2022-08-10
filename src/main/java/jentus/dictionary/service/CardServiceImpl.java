package jentus.dictionary.service;

import jentus.dictionary.exception.CardNotFoundException;
import jentus.dictionary.exception.SlotNotFoundException;
import jentus.dictionary.model.*;
import jentus.dictionary.model.dto.CardWriterDto;
import jentus.dictionary.repository.*;
import lombok.AllArgsConstructor;
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
        slotRepository.findAllById(cardWriterDto.getCardListIds()).forEach(cardList -> {
            CardAndSlot cardAndSlot = new CardAndSlot();
            cardAndSlot.setCard(card);
            cardAndSlot.setSlot(cardList);
            cardAndSlots.add(cardAndSlot);
        });
        cardAndSlotRepository.saveAll(cardAndSlots);
    }

    @Override
    public List<Card> getAllBySlotId(Long slotId, Pageable pageable) {
        Slot slot = slotRepository.findById(slotId).orElseThrow(SlotNotFoundException::new);
        return cardRepository.findAllBySlotId(slot.getId(), pageable);
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow(CardNotFoundException::new);
    }
}
