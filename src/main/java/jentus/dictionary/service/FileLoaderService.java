package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.model.dto.FileDto;
import org.springframework.http.ResponseEntity;

public interface FileLoaderService {
    ResponseEntity<FileDto> download(String fileName, String format, String url) throws FileUploadException;
}
