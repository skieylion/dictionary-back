package jentus.dictionary.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FileDto {
    private String fileName;
    private String format;
    private String data64;
}
