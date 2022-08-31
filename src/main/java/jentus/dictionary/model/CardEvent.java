package jentus.dictionary.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "cardEvent")
public class CardEvent implements Comparable<CardEvent> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "eventDate")
    private Date eventDate;

    @ManyToOne(targetEntity = Card.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cardId")
    @JsonIgnore
    private Card card;

    @Override
    public int compareTo(CardEvent o) {
        return o.getEventDate().compareTo(getEventDate());
    }
}
