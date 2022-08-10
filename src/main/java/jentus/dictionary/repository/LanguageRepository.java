package jentus.dictionary.repository;

import jentus.dictionary.config.HttpConfig;
import jentus.dictionary.model.Entry;
import jentus.dictionary.model.Search;
import jentus.dictionary.model.Thesaurus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "https://od-api.oxforddictionaries.com/api/v2",
        value = "languageRepository",
        configuration = HttpConfig.class
)
public interface LanguageRepository {
    @GetMapping("/search/{source_lang}")
    Search find(@PathVariable("source_lang") String lang, @RequestParam("q") String q, @RequestParam("limit") byte limit);

    @GetMapping("/thesaurus/{source_lang}/{word_id}")
    Thesaurus getThesaurus(
            @PathVariable("source_lang") String lang,
            @PathVariable("word_id") String wordId,
            @RequestParam(value = "strictMatch") boolean strictMatch
    );

    @GetMapping("/entries/{source_lang}/{word_id}")
    Entry getEntry(
            @PathVariable("source_lang") String lang,
            @PathVariable("word_id") String wordId
    );
}
