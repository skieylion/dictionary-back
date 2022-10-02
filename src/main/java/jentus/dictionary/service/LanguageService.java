package jentus.dictionary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jentus.dictionary.model.Entry;
import jentus.dictionary.model.NameValuePair;
import jentus.dictionary.model.dto.EntryDto;

import java.util.List;

public interface LanguageService {
    List<EntryDto> getEntries(String wordId) throws JsonProcessingException;
    List<NameValuePair> lookFor(String query) throws JsonProcessingException;
}
