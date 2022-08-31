package jentus.dictionary.controller;

import jentus.dictionary.repository.FileRepository;
import jentus.dictionary.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class TestCtrl {
    private final LanguageService languageService;
    private final FileRepository fileRepository;

    @GetMapping("/test")
    public void test() {
        String photoId = UUID.randomUUID().toString();
        //fileRepository.upload(photoId, "asdfasdf".getBytes(StandardCharsets.UTF_8));
    }
}