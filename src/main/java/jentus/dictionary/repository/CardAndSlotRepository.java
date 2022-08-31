package jentus.dictionary.repository;

import jentus.dictionary.model.CardAndSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardAndSlotRepository extends CrudRepository<CardAndSlot, Long> {
    @Modifying
    @Query("delete from CardAndSlot cs where cs.card.id=:cardId")
    void removeByCardId(@Param("cardId") Long cardId);

    @Modifying
    @Query("delete from CardAndSlot cs where cs.slot.id=:slotId")
    void removeBySlotId(@Param("slotId") Long slotId);
}
