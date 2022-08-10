package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhotoService {
    List<String> findPhotos(String query);
    ResponseEntity<String> downloadPhoto(String url) throws FileUploadException;
}
