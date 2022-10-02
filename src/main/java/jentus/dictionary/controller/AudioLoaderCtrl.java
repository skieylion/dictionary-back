package jentus.dictionary.controller;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.model.dto.FileDto;
import jentus.dictionary.service.FileLoaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class AudioLoaderCtrl {
    private final FileLoaderService fileLoaderService;

    private static String format(String url) {
        String[] arr = url.split("\\.");
        return arr[arr.length - 1];
    }

    private static String name(String url) {
        String[] arr = url.split("\\.");
        List<String> stringList = new ArrayList<>(Arrays.asList(arr).subList(0, arr.length - 1));
        String link = String.join("", stringList);
        String[] arr2 = link.split("/");
        return arr2[arr2.length - 1];
    }

    @GetMapping("loader/audio")
    public ResponseEntity<FileDto> download(@RequestParam("url") String url) throws FileUploadException {
        return fileLoaderService.download(name(url), format(url), url);
    }
}
