package jentus.dictionary.repository;

import jentus.dictionary.model.Slot;
import jentus.dictionary.model.SlotStat;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Long> {
    List<Slot> findAll();
}
