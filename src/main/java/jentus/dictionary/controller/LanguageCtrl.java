package jentus.dictionary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jentus.dictionary.model.Entry;
import jentus.dictionary.model.NameValuePair;
import jentus.dictionary.model.dto.EntryDto;
import jentus.dictionary.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class LanguageCtrl {

    private final LanguageService languageService;

    @GetMapping("/entries")
    public List<EntryDto> entries(@RequestParam("wordId") String wordId) throws JsonProcessingException {
        return languageService.getEntries(wordId);
    }

    @GetMapping("/search")
    public List<NameValuePair> search(@RequestParam("query") String query) throws JsonProcessingException {
        return languageService.lookFor(query);
    }
}
