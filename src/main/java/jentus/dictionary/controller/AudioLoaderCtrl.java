package jentus.dictionary.controller;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.service.FileLoaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class AudioLoaderCtrl {
    private final FileLoaderService fileLoaderService;

    private String getFormat(String url) {
        String[] arr = url.split("/");
        String name = arr[arr.length - 1];
        arr = name.split("\\.");
        return "." + arr[1];
    }

    @GetMapping("loader/audio")
    public ResponseEntity<String> download(@RequestParam("url") String url) throws FileUploadException {
        return fileLoaderService.download(url, getFormat(url));
    }
}
