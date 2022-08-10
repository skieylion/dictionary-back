package jentus.dictionary.service;

import jentus.dictionary.model.Card;
import jentus.dictionary.model.dto.CardWriterDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService {
    void save(CardWriterDto cardWriterDto);
    List<Card> getAllBySlotId(Long slotId, Pageable pageable);
    Card getCardById(Long cardId);
}
