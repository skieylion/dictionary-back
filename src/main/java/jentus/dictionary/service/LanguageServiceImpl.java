package jentus.dictionary.service;

import jentus.dictionary.model.Entry;
import jentus.dictionary.model.dto.EntryDto;
import jentus.dictionary.repository.LanguageRepository;
import jentus.dictionary.service.mapper.LanguageMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;
    private final static String en = "en";
    private final static String en_gb = "en-gb";
    private final static byte limit = 5;

    @Override
    @Cacheable("entries")
    public List<EntryDto> find(String query) {
        List<Entry> entryList = new ArrayList<>();
        languageRepository.find(en, query, limit).getResults().forEach(result -> {
            entryList.add(languageRepository.getEntry(en_gb, result.getId()));
        });
        return languageMapper.convert(entryList);
    }
}
