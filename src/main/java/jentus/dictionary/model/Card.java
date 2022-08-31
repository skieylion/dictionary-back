package jentus.dictionary.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "card")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "definition")
    private String definition;
    @Column(name = "translate")
    private String translate;
    @ManyToOne(targetEntity = PartOfSpeech.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "partOfSpeechId")
    private PartOfSpeech partOfSpeech;
    @Column(name = "expression")
    private String expression;
    @Column(name = "photoId")
    @Type(type = "pg-uuid")
    private UUID photoId;
    @OneToMany(targetEntity = Example.class, mappedBy = "card", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Example> examples = new HashSet<>();
    @OneToMany(targetEntity = Transcription.class, mappedBy = "card", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transcription> transcriptions = new HashSet<>();
    @ManyToMany(targetEntity = Slot.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "CardAndSlot",
            joinColumns = @JoinColumn(name = "cardId"),
            inverseJoinColumns = @JoinColumn(name = "slotId")
    )
    private Set<Slot> slots = new HashSet<>();
    @Column(name = "state")
    private boolean state;
    @OneToMany(targetEntity = CardEvent.class, mappedBy = "card", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CardEvent> cardEvents = new HashSet<>();
}
