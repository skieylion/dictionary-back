package jentus.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "slot")
@Data
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Type(type = "pg-uuid")
    private UUID fileId;

    @ManyToMany(mappedBy = "slots", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Card> cards = new HashSet<>();
}
