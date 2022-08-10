package jentus.dictionary.controller;

import jentus.dictionary.model.Card;
import jentus.dictionary.model.dto.CardWriterDto;
import jentus.dictionary.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class CardCtrl {
    private final CardService cardService;

    @PostMapping("/cards")
    public void saveContextByContextListId(
            @RequestBody CardWriterDto cardWriterDto
    ) {
        cardService.save(cardWriterDto);
    }

    @GetMapping("/slots/{slotId}/cards")
    public List<Card> getAllBySlotId(
            @PathVariable("slotId") Long slotId,
            @RequestParam("offset") short offset,
            @RequestParam("limit") short limit
    ) {
        Pageable pageable = PageRequest.of(offset, limit);
        return cardService.getAllBySlotId(slotId, pageable);
    }

    @GetMapping("/cards/{cardId}")
    public Card getCardById(@PathVariable("cardId") Long cardId) {
        return cardService.getCardById(cardId);
    }
}
