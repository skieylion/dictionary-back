package jentus.dictionary.service.mapper;

import jentus.dictionary.model.Card;
import jentus.dictionary.model.dto.CardStudentDto;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CardStudentMapper {

    default CardStudentDto convert(Card card) {
        CardStudentDto cardStudentDto = new CardStudentDto();
        cardStudentDto.setId(card.getId());
        cardStudentDto.setDefinition(card.getDefinition());
        cardStudentDto.setExpression(card.getExpression());
        cardStudentDto.setPhotoId(card.getPhotoId());
        cardStudentDto.setState(card.isState());
        cardStudentDto.setCardEvents(card.getCardEvents());
        cardStudentDto.setExamples(card.getExamples());
        cardStudentDto.setSlots(card.getSlots());
        cardStudentDto.setTranscriptions(card.getTranscriptions());
        cardStudentDto.setTranslate(card.getTranslate());
        cardStudentDto.setPartOfSpeech(card.getPartOfSpeech());
        cardStudentDto.setCardEvents(card.getCardEvents());
        cardStudentDto.setRepeat(false);
        if (card.getCardEvents() != null && card.getCardEvents().size() > 0 && !card.isState()) {
            card.getCardEvents().stream().sorted().findFirst().ifPresent(cardEvent -> {
                int count = card.getCardEvents().size() - 1;
                long[] times = {30, 1440, 30240, 129600};
                Date date = new Date();
                long currentTime = date.getTime();
                long eventTime = cardEvent.getEventDate().getTime();
                long delta = currentTime - eventTime;
                if (count < times.length) {
                    if (delta > times[count] * 60 * 1000) {
                        cardStudentDto.setRepeat(true);
                    } else {
                        cardStudentDto.setRepeat(false);
                        cardStudentDto.setDeltaSecondTime((int) (delta / 1000 / 60));
                    }
                } else {
                    cardStudentDto.setState(true);
                    cardStudentDto.setRepeat(false);
                }
            });
        }

        return cardStudentDto;
    }

    List<CardStudentDto> convert(List<Card> cardList);
}