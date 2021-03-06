package jentus.dictionary.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Context")
@Getter
@Setter
public class Context {
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

    @ManyToOne(targetEntity = Expression.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "expressionId")
    private Expression expression;

    @Column(name = "photoId")
    @Type(type="pg-uuid")
    private UUID photoId;

    @OneToMany(targetEntity = Example.class,mappedBy = "context", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Example> examples;

    @OneToMany(targetEntity = ContextEvent.class, mappedBy = "context", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ContextEvent> contextEvents;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = ContextList.class,fetch = FetchType.EAGER)
    @JoinTable(
            name = "ContextAndContextList",
            joinColumns = @JoinColumn(name = "contextId"),
            inverseJoinColumns = @JoinColumn(name = "contextListId")
    )
    private Set<ContextList> contextLists=new HashSet<>();

}
