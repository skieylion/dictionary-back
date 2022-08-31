package jentus.dictionary.repository;

import jentus.dictionary.model.CardEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardEventRepository  extends JpaRepository<CardEvent, Long> {
}
