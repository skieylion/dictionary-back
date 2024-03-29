package jentus.dictionary.service;

import jentus.dictionary.exception.SlotNotFoundException;
import jentus.dictionary.model.Card;
import jentus.dictionary.model.Slot;
import jentus.dictionary.model.SlotStat;
import jentus.dictionary.model.dto.SlotDto;
import jentus.dictionary.repository.*;
import jentus.dictionary.repository.batis.SlotStatRepository;
import jentus.dictionary.service.mapper.SlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository;
    private final CardRepository cardRepository;
    private final CardService cardService;
    private final CardAndSlotRepository cardAndSlotRepository;
    private final FileRepository fileRepository;
    private final SlotMapper slotMapper;
    private final SlotStatRepository slotStatRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SlotDto> findAll() {
        List<Slot> slotList = slotRepository.findAll();
        List<SlotStat> slotStatList = slotStatRepository.getSlotStat();
        return slotMapper.convert(slotList, slotStatList);
    }

    @Override
    @Transactional
    public void save(SlotDto slotDto) {
        Slot slot = new Slot();
        slot.setName(slotDto.getName());
        if (slotDto.getFileId() != null) {
            slot.setFileId(UUID.fromString(slotDto.getFileId()));
        }
        slotRepository.save(slot);
    }

    @Override
    @Transactional
    public void delete(long slotId) {
        Slot slot = slotRepository.findById(slotId).orElseThrow(SlotNotFoundException::new);
        Set<Card> cards = slot.getCards();
        if (cards != null) {
            for (Card card : cards) {
                Set<Slot> slots = card.getSlots();
                if (slots != null && slots.size() == 1) {
                    cardService.deleteCard(card.getId());
                }
            }

        }
        cardAndSlotRepository.removeBySlotId(slot.getId());
        if (slot.getFileId() != null) {
            fileRepository.delete(slot.getFileId().toString());
        }
        slotRepository.delete(slot);
    }


}
