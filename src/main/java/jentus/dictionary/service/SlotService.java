package jentus.dictionary.service;

import jentus.dictionary.model.Slot;
import jentus.dictionary.model.dto.SlotDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SlotService {
    List<Slot> findAll();
    void save(SlotDto slotDto);
    void delete(long slotId);
}
