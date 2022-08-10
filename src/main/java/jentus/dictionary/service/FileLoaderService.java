package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import org.springframework.http.ResponseEntity;

public interface FileLoaderService {
    ResponseEntity<String> download(String url, String format) throws FileUploadException;
}
