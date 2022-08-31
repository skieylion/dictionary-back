package jentus.dictionary.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CardWriterDto {
    private String photoId;
    private String expression;
    private long partOfSpeechId;
    private String definition;
    private String translate;
    private List<TranscriptionDto> transcriptionList;
    private List<String> exampleList;
    private List<Long> slotIds;

    @Override
    public String toString() {
        return "CardDto{" +
                "photoId='" + photoId + '\'' +
                ", expression='" + expression + '\'' +
                ", partOfSpeechId=" + partOfSpeechId +
                ", definition='" + definition + '\'' +
                ", translate='" + translate + '\'' +
                ", transcriptionList=" + transcriptionList +
                ", exampleList=" + exampleList +
                ", slotIds=" + slotIds +
                '}';
    }
}
