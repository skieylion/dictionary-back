package jentus.dictionary.service;

import jentus.dictionary.model.Slot;
import jentus.dictionary.model.dto.SlotDto;
import jentus.dictionary.repository.SlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Slot> findAll() {
        return slotRepository.findAll();
    }

    @Override
    @Transactional
    public void save(SlotDto slotDto) {
        Slot slot = new Slot();
        slot.setName(slotDto.getName());
        slotRepository.save(slot);
    }

}
