package jentus.dictionary.service.mapper;

import jentus.dictionary.model.Entry;
import jentus.dictionary.model.NameValuePair;
import jentus.dictionary.model.Search;
import jentus.dictionary.model.dto.EntryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "name", source = "label")
    })
    NameValuePair convert(Search.Result v);

    default List<EntryDto> convert(Entry entry) {
        List<EntryDto> entryDtoList = new ArrayList<>();
        for (Entry.Result result : entry.getResults()) {
            String lexemeId = result.getId();
            for (Entry.LexicalEntry lexicalEntry : result.getLexicalEntries()) {
                String text = lexicalEntry.getText();
                String lexicalCategoryId = lexicalEntry.getLexicalCategory().getId();
                String lexicalCategoryText = lexicalEntry.getLexicalCategory().getText();
                for (Entry.SubEntry subEntry : lexicalEntry.getEntries()) {
                    List<EntryDto.TranscriptionDto> transcriptionDtoList = new ArrayList<>();
                    if (subEntry.getPronunciations() != null) {
                        for (Entry.Pronunciation pronunciation : subEntry.getPronunciations()) {
                            EntryDto.TranscriptionDto transcriptionDto = new EntryDto.TranscriptionDto();
                            transcriptionDto.setDialect(pronunciation.getDialects().get(0));
                            transcriptionDto.setPhoneticSpelling(pronunciation.getPhoneticSpelling());
                            transcriptionDto.setAudioFile(pronunciation.getAudioFile());
                            transcriptionDtoList.add(transcriptionDto);
                        }
                    }
                    for (Entry.Sense sense : subEntry.getSenses()) {
                        String definition = sense.getDefinitions().get(0);
                        List<String> examples = new ArrayList<>();
                        if (sense.getExamples() != null) {
                            sense.getExamples().forEach(example -> examples.add(example.getText()));
                        }
                        EntryDto entryDto = new EntryDto();
                        entryDto.setDefinition(definition);
                        entryDto.setExamples(examples);
                        entryDto.setLexemeId(lexemeId);
                        entryDto.setText(text);
                        entryDto.setLexicalCategoryId(lexicalCategoryId);
                        entryDto.setLexicalCategoryText(lexicalCategoryText);
                        entryDto.setTranscriptionList(transcriptionDtoList);
                        entryDtoList.add(entryDto);
                    }
                }
            }
        }
        return entryDtoList;
    }
}