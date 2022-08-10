package jentus.dictionary.repository;

import jentus.dictionary.model.Card;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select c from Card c join c.slots s where s.id=:slotId")
    List<Card> findAllBySlotId(@Param("slotId") Long slotId, Pageable pageable);

//    @Query("select c from Card c join c.slots s where s.id=:slotId")
//    List<Card> findAllBySlotId(@Param("slotId") Long slotId, Pageable pageable);
}
