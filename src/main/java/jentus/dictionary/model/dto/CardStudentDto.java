package jentus.dictionary.model.dto;

import jentus.dictionary.model.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class CardStudentDto {
    private long id;
    private String definition;
    private String translate;
    private PartOfSpeech partOfSpeech;
    private String expression;
    private UUID photoId;
    private Set<Example> examples = new HashSet<>();
    private Set<Transcription> transcriptions = new HashSet<>();
    private Set<Slot> slots = new HashSet<>();
    private boolean state;
    private Set<CardEvent> cardEvents = new HashSet<>();
    private short countCardEvent;
    private boolean repeat;
    private int deltaSecondTime;
}
