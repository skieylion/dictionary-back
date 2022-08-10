package jentus.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Transcription")
@Getter
@Setter
public class Transcription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private String value;

    @ManyToOne(targetEntity = Card.class)
    @JoinColumn(name = "cardId")
    @JsonIgnore
    private Card card;

    @Enumerated(EnumType.STRING)
    @Column(name = "variant")
    private TranscriptionVariant variant;

    @Column(name = "fileId")
    @Type(type = "pg-uuid")
    private UUID fileId;
}
