package jentus.dictionary.repository;

import jentus.dictionary.model.CardAndSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardAndSlotRepository extends CrudRepository<CardAndSlot, Long> {
}
