package jentus.dictionary.controller;

import jentus.dictionary.model.*;
import jentus.dictionary.model.dto.SlotDto;
import jentus.dictionary.service.SlotService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class SlotCtrl {

    private final SlotService slotService;

    @GetMapping("/slots")
    public List<SlotDto> findAllWithoutCards() {
        return slotService.findAll();
    }

    @PostMapping("/slots")
    public void save(@RequestBody SlotDto slotDto) {
        slotService.save(slotDto);
    }

    @DeleteMapping("/slots/{id}")
    public void deleteSlot(
            @PathVariable("id") long slotId
    ) {
        slotService.delete(slotId);
    }
}
