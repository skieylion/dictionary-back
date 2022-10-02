package jentus.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {
    private String id;
    private Metadata metadata;
    private List<Result> results;
    private String word;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Metadata {
        private String operation;
        private String provider;
        private String schema;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String id;
        private String language;
        private List<LexicalEntry> lexicalEntries;
        private String type;
        private String word;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class KeyText {
        private String id;
        private String text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Text {
        private String text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LanguageText {
        private String language;
        private String text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ThesaurusLink {
        private String entry_id;
        private String sense_id;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GrammaticalFeature {
        private String id;
        private String text;
        private String type;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pronunciation {
        private String audioFile;
        private List<String> dialects;
        private String phoneticNotation;
        private String phoneticSpelling;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LexicalEntry {
        private List<SubEntry> entries;
        private String language;
        private KeyText lexicalCategory;
        private List<KeyText> phrasalVerbs;
        private List<KeyText> phrases;
        private String text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubSense {
        private List<String> definitions;
        private List<Text> examples;
        private String id;
        private List<KeyText> semanticClasses;
        private List<String> shortDefinitions;
        private List<LanguageText> synonyms;
        private List<ThesaurusLink> thesaurusLinks;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sense {
        private List<String> definitions;
        private List<Text> examples;
        private String id;
        private List<KeyText> semanticClasses;
        private List<String> shortDefinitions;
        private List<SubSense> subsenses;
        private List<LanguageText> synonyms;
        private List<ThesaurusLink> thesaurusLinks;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubEntry {
        private List<String> etymologies;
        private List<GrammaticalFeature> grammaticalFeatures;
        private List<Pronunciation> pronunciations;
        private List<Sense> senses;
    }
}
