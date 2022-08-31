package jentus.dictionary.controller;

import jentus.dictionary.model.Card;
import jentus.dictionary.model.dto.CardStudentDto;
import jentus.dictionary.model.dto.CardWriterDto;
import jentus.dictionary.service.CardService;
import jentus.dictionary.service.mapper.CardStudentMapper;
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
    private final CardStudentMapper cardStudentMapper;

    @PostMapping("/cards")
    public void saveContextByContextListId(
            @RequestBody CardWriterDto cardWriterDto
    ) {
        cardService.save(cardWriterDto);
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(
            @PathVariable("id") Long cardId
    ) {
        cardService.deleteCard(cardId);
    }

    @PostMapping("/repeat/cards/{id}")
    public void repeatCard(
            @PathVariable("id") Long cardId
    ) {
        cardService.repeatCard(cardId);
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

    @GetMapping("student/slots/{slotId}/cards")
    public List<CardStudentDto> getStudentCardsBySlotId(
            @PathVariable("slotId") Long slotId,
            @RequestParam("limit") short limit
    ) {
        return cardStudentMapper.convert(cardService.getStudentCardsBySlotId(slotId, limit));
    }

    @GetMapping("/cards/{cardId}")
    public Card getCardById(@PathVariable("cardId") Long cardId) {
        return cardService.getCardById(cardId);
    }
}
