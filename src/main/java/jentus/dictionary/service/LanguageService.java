package jentus.dictionary.service;

import jentus.dictionary.model.Entry;
import jentus.dictionary.model.NameValuePair;
import jentus.dictionary.model.dto.EntryDto;

import java.util.List;

public interface LanguageService {
    List<EntryDto> find(String query);
}
