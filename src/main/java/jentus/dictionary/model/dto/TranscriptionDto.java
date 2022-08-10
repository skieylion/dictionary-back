package jentus.dictionary.model.dto;

import jentus.dictionary.model.TranscriptionVariant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranscriptionDto {
    private String value;
    private TranscriptionVariant variant;
    private String fileId;
}
