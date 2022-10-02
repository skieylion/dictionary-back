package jentus.dictionary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jentus.dictionary.model.Entry;
import jentus.dictionary.model.NameValuePair;
import jentus.dictionary.model.Search;
import jentus.dictionary.model.dto.EntryDto;
import jentus.dictionary.repository.LanguageRepository;
import jentus.dictionary.service.mapper.LanguageMapper;
import lombok.AllArgsConstructor;
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
    public List<EntryDto> getEntries(String wordId) throws JsonProcessingException {
        //languageRepository.getEntry(en_gb, wordId)
        return languageMapper.convert(testEntry());
    }

    @Override
    public List<NameValuePair> lookFor(String query) throws JsonProcessingException {
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        testSearch().getResults().forEach(result -> {
            NameValuePair nameValuePair = new NameValuePair();
            nameValuePair.setValue(result.getId());
            nameValuePair.setName(result.getLabel());
            nameValuePairList.add(nameValuePair);
        });
        return nameValuePairList;
    }

    private Entry testEntry() throws JsonProcessingException {
        String result = "{\"id\":\"word\",\"metadata\":{\"operation\":\"retrieve\",\"provider\":\"Oxford University Press\",\"schema\":\"RetrieveEntry\"},\"results\":[{\"id\":\"word\",\"language\":\"en-gb\",\"lexicalEntries\":[{\"derivatives\":[{\"id\":\"wordage\",\"text\":\"wordage\"}],\"entries\":[{\"etymologies\":[\"Old English word, of Germanic origin; related to Dutch woord and German Wort, from an Indo-European root shared by Latin verbum ‘word’\"],\"pronunciations\":[{\"audioFile\":\"https://audio.oxforddictionaries.com/en/mp3/whirred__gb_1.mp3\",\"dialects\":[\"British English\"],\"phoneticNotation\":\"IPA\",\"phoneticSpelling\":\"wəːd\"}],\"senses\":[{\"definitions\":[\"a single distinct meaningful element of speech or writing, used with others (or sometimes alone) to form a sentence and typically shown with a space on either side when written or printed\"],\"domainClasses\":[{\"id\":\"linguistics\",\"text\":\"Linguistics\"}],\"examples\":[{\"text\":\"I don't like the word ‘unofficial’\"},{\"text\":\"so many words for so few ideas\"}],\"id\":\"m_en_gbus1167030.006\",\"semanticClasses\":[{\"id\":\"word\",\"text\":\"Word\"}],\"shortDefinitions\":[\"single meaningful element of speech or writing\"],\"subsenses\":[{\"definitions\":[\"a single distinct conceptual unit of language, comprising inflected and variant forms.\"],\"domainClasses\":[{\"id\":\"linguistics\",\"text\":\"Linguistics\"}],\"id\":\"m_en_gbus1167030.009\",\"semanticClasses\":[{\"id\":\"word\",\"text\":\"Word\"}],\"shortDefinitions\":[\"single distinct conceptual unit of language\"]},{\"definitions\":[\"something spoken or written; a remark or statement\"],\"examples\":[{\"text\":\"his grandfather's words had been meant kindly\"},{\"text\":\"a word of warning\"}],\"id\":\"m_en_gbus1167030.010\",\"notes\":[{\"text\":\"usually \\\"words\\\"\",\"type\":\"wordFormNote\"}],\"semanticClasses\":[{\"id\":\"statement\",\"text\":\"Statement\"}],\"shortDefinitions\":[\"something spoken or written\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"remark\"},{\"language\":\"en\",\"text\":\"comment\"},{\"language\":\"en\",\"text\":\"statement\"},{\"language\":\"en\",\"text\":\"utterance\"},{\"language\":\"en\",\"text\":\"observation\"},{\"language\":\"en\",\"text\":\"pronouncement\"},{\"language\":\"en\",\"text\":\"declaration\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.002\"}]},{\"definitions\":[\"even the smallest amount of something spoken or written\"],\"examples\":[{\"text\":\"don't believe a word of it\"}],\"id\":\"m_en_gbus1167030.011\",\"notes\":[{\"text\":\"with negative\",\"type\":\"grammaticalNote\"},{\"text\":\"\\\"a word\\\"\",\"type\":\"wordFormNote\"}],\"semanticClasses\":[{\"id\":\"small_amount\",\"text\":\"Small_Amount\"}],\"shortDefinitions\":[\"even smallest amount of something spoken or written\"]},{\"definitions\":[\"angry talk\"],\"examples\":[{\"text\":\"her father would have had words with her about that\"}],\"id\":\"m_en_gbus1167030.013\",\"notes\":[{\"text\":\"\\\"words\\\"\",\"type\":\"wordFormNote\"}],\"semanticClasses\":[{\"id\":\"speech\",\"text\":\"Speech\"}],\"shortDefinitions\":[\"angry talk\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"quarrel\"},{\"language\":\"en\",\"text\":\"argue\"},{\"language\":\"en\",\"text\":\"disagree\"},{\"language\":\"en\",\"text\":\"row\"},{\"language\":\"en\",\"text\":\"squabble\"},{\"language\":\"en\",\"text\":\"bicker\"},{\"language\":\"en\",\"text\":\"fight\"},{\"language\":\"en\",\"text\":\"wrangle\"},{\"language\":\"en\",\"text\":\"dispute\"},{\"language\":\"en\",\"text\":\"feud\"},{\"language\":\"en\",\"text\":\"have a row\"},{\"language\":\"en\",\"text\":\"cross swords\"},{\"language\":\"en\",\"text\":\"lock horns\"},{\"language\":\"en\",\"text\":\"clash\"},{\"language\":\"en\",\"text\":\"be at each other's throats\"}],\"thesaurusLinks\":[{\"entry_id\":\"have_words\",\"sense_id\":\"t_en_gb0016373.011\"}]},{\"definitions\":[\"speech as distinct from action\"],\"examples\":[{\"text\":\"he conforms in word and deed to the values of a society that he rejects\"}],\"id\":\"m_en_gbus1167030.015\",\"notes\":[{\"text\":\"mass noun\",\"type\":\"grammaticalNote\"}],\"semanticClasses\":[{\"id\":\"speech\",\"text\":\"Speech\"}],\"shortDefinitions\":[\"speech as distinct from action\"]}],\"synonyms\":[{\"language\":\"en\",\"text\":\"term\"},{\"language\":\"en\",\"text\":\"name\"},{\"language\":\"en\",\"text\":\"expression\"},{\"language\":\"en\",\"text\":\"designation\"},{\"language\":\"en\",\"text\":\"locution\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.001\"}]},{\"definitions\":[\"a command, password, or signal\"],\"examples\":[{\"text\":\"someone gave me the word to start playing\"}],\"id\":\"m_en_gbus1167030.017\",\"semanticClasses\":[{\"id\":\"utterance\",\"text\":\"Utterance\"}],\"shortDefinitions\":[\"command or signal\"],\"subsenses\":[{\"definitions\":[\"communication; news\"],\"examples\":[{\"text\":\"I was afraid to leave Edinburgh in case there was word from the War Office\"},{\"text\":\"the prince sent word to the king asking him to send reinforcements\"}],\"id\":\"m_en_gbus1167030.018\",\"notes\":[{\"text\":\"mass noun\",\"type\":\"grammaticalNote\"}],\"semanticClasses\":[{\"id\":\"information\",\"text\":\"Information\"},{\"id\":\"message\",\"text\":\"Message\"}],\"shortDefinitions\":[\"communication\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"news\"},{\"language\":\"en\",\"text\":\"information\"},{\"language\":\"en\",\"text\":\"communication\"},{\"language\":\"en\",\"text\":\"intelligence\"},{\"language\":\"en\",\"text\":\"notice\"},{\"language\":\"en\",\"text\":\"rumour\"},{\"language\":\"en\",\"text\":\"hearsay\"},{\"language\":\"en\",\"text\":\"talk\"},{\"language\":\"en\",\"text\":\"gossip\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.006\"},{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.007\"}]}],\"synonyms\":[{\"language\":\"en\",\"text\":\"instruction\"},{\"language\":\"en\",\"text\":\"order\"},{\"language\":\"en\",\"text\":\"command\"},{\"language\":\"en\",\"text\":\"command\"},{\"language\":\"en\",\"text\":\"order\"},{\"language\":\"en\",\"text\":\"decree\"},{\"language\":\"en\",\"text\":\"edict\"},{\"language\":\"en\",\"text\":\"mandate\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.008\"},{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.009\"}]},{\"definitions\":[\"one's account of the truth, especially when it differs from that of another person\"],\"examples\":[{\"text\":\"in court it would have been his word against mine\"}],\"id\":\"m_en_gbus1167030.020\",\"notes\":[{\"text\":\"\\\"one's word\\\"\",\"type\":\"wordFormNote\"}],\"semanticClasses\":[{\"id\":\"account\",\"text\":\"Account\"}],\"shortDefinitions\":[\"one's account of truth\"],\"subsenses\":[{\"definitions\":[\"a promise or assurance\"],\"examples\":[{\"text\":\"everything will be taken care of—you have my word\"}],\"id\":\"m_en_gbus1167030.021\",\"semanticClasses\":[{\"id\":\"promise\",\"text\":\"Promise\"}],\"shortDefinitions\":[\"promise or assurance\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"promise\"},{\"language\":\"en\",\"text\":\"word of honour\"},{\"language\":\"en\",\"text\":\"assurance\"},{\"language\":\"en\",\"text\":\"guarantee\"},{\"language\":\"en\",\"text\":\"undertaking\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.004\"}]}]},{\"definitions\":[\"the text or spoken part of a play, opera, or other performed piece; a script\"],\"domainClasses\":[{\"id\":\"theatre\",\"text\":\"Theatre\"}],\"examples\":[{\"text\":\"he had to learn his words\"}],\"id\":\"m_en_gbus1167030.023\",\"notes\":[{\"text\":\"\\\"words\\\"\",\"type\":\"wordFormNote\"}],\"semanticClasses\":[{\"id\":\"text\",\"text\":\"Text\"}],\"shortDefinitions\":[\"text or spoken part of play\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"script\"},{\"language\":\"en\",\"text\":\"text\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.003\"}]},{\"definitions\":[\"a basic unit of data in a computer, typically 16 or 32 bits long.\"],\"domainClasses\":[{\"id\":\"computing\",\"text\":\"Computing\"}],\"id\":\"m_en_gbus1167030.025\",\"semanticClasses\":[{\"id\":\"computing_unit\",\"text\":\"Computing_Unit\"}],\"shortDefinitions\":[\"basic unit of data in computer\"]}]}],\"language\":\"en-gb\",\"lexicalCategory\":{\"id\":\"noun\",\"text\":\"Noun\"},\"phrasalVerbs\":[{\"id\":\"word_up\",\"text\":\"word up\"}],\"phrases\":[{\"id\":\"a_word_to_the_wise\",\"text\":\"a word to the wise\"},{\"id\":\"at_a_word\",\"text\":\"at a word\"},{\"id\":\"be_as_good_as_one%27s_word\",\"text\":\"be as good as one's word\"},{\"id\":\"break_one%27s_word\",\"text\":\"break one's word\"},{\"id\":\"have_a_word\",\"text\":\"have a word\"},{\"id\":\"have_a_word_in_someone%27s_ear\",\"text\":\"have a word in someone's ear\"},{\"id\":\"in_a_word\",\"text\":\"in a word\"},{\"id\":\"in_other_words\",\"text\":\"in other words\"},{\"id\":\"in_so_many_words\",\"text\":\"in so many words\"},{\"id\":\"keep_one%27s_word\",\"text\":\"keep one's word\"},{\"id\":\"my_word\",\"text\":\"my word\"},{\"id\":\"of_few_words\",\"text\":\"of few words\"},{\"id\":\"of_one%27s_word\",\"text\":\"of one's word\"},{\"id\":\"put_something_into_words\",\"text\":\"put something into words\"},{\"id\":\"put_words_into_someone%27s_mouth\",\"text\":\"put words into someone's mouth\"},{\"id\":\"spread_the_word\",\"text\":\"spread the word\"},{\"id\":\"take_someone_at_their_word\",\"text\":\"take someone at their word\"},{\"id\":\"take_someone%27s_word\",\"text\":\"take someone's word\"},{\"id\":\"take_the_words_out_of_someone%27s_mouth\",\"text\":\"take the words out of someone's mouth\"},{\"id\":\"the_Word\",\"text\":\"the Word\"},{\"id\":\"the_word_on_the_street\",\"text\":\"the word on the street\"},{\"id\":\"too_%E2%80%94_for_words\",\"text\":\"too — for words\"},{\"id\":\"waste_words\",\"text\":\"waste words\"},{\"id\":\"word_for_word\",\"text\":\"word for word\"},{\"id\":\"word_gets_around\",\"text\":\"word gets around\"},{\"id\":\"word_of_honour\",\"text\":\"word of honour\"},{\"id\":\"word_of_mouth\",\"text\":\"word of mouth\"},{\"id\":\"words_fail_me\",\"text\":\"words fail me\"}],\"text\":\"word\"},{\"derivatives\":[{\"id\":\"wordage\",\"text\":\"wordage\"}],\"entries\":[{\"grammaticalFeatures\":[{\"id\":\"transitive\",\"text\":\"Transitive\",\"type\":\"Subcategorization\"}],\"pronunciations\":[{\"audioFile\":\"https://audio.oxforddictionaries.com/en/mp3/whirred__gb_1.mp3\",\"dialects\":[\"British English\"],\"phoneticNotation\":\"IPA\",\"phoneticSpelling\":\"wəːd\"}],\"senses\":[{\"definitions\":[\"express (something spoken or written) in particular words\"],\"examples\":[{\"text\":\"he words his request in a particularly ironic way\"},{\"notes\":[{\"text\":\"as adjective, with submodifier \\\"worded\\\"\",\"type\":\"wordFormNote\"}],\"text\":\"a strongly worded letter of protest\"}],\"id\":\"m_en_gbus1167030.043\",\"shortDefinitions\":[\"express something spoken or written\"],\"synonyms\":[{\"language\":\"en\",\"text\":\"phrase\"},{\"language\":\"en\",\"text\":\"express\"},{\"language\":\"en\",\"text\":\"put\"},{\"language\":\"en\",\"text\":\"couch\"},{\"language\":\"en\",\"text\":\"frame\"},{\"language\":\"en\",\"text\":\"set forth\"},{\"language\":\"en\",\"text\":\"formulate\"},{\"language\":\"en\",\"text\":\"style\"}],\"thesaurusLinks\":[{\"entry_id\":\"word\",\"sense_id\":\"t_en_gb0016373.015\"}]}]}],\"language\":\"en-gb\",\"lexicalCategory\":{\"id\":\"verb\",\"text\":\"Verb\"},\"phrasalVerbs\":[{\"id\":\"word_up\",\"text\":\"word up\"}],\"phrases\":[{\"id\":\"a_word_to_the_wise\",\"text\":\"a word to the wise\"},{\"id\":\"at_a_word\",\"text\":\"at a word\"},{\"id\":\"be_as_good_as_one%27s_word\",\"text\":\"be as good as one's word\"},{\"id\":\"break_one%27s_word\",\"text\":\"break one's word\"},{\"id\":\"have_a_word\",\"text\":\"have a word\"},{\"id\":\"have_a_word_in_someone%27s_ear\",\"text\":\"have a word in someone's ear\"},{\"id\":\"in_a_word\",\"text\":\"in a word\"},{\"id\":\"in_other_words\",\"text\":\"in other words\"},{\"id\":\"in_so_many_words\",\"text\":\"in so many words\"},{\"id\":\"keep_one%27s_word\",\"text\":\"keep one's word\"},{\"id\":\"my_word\",\"text\":\"my word\"},{\"id\":\"of_few_words\",\"text\":\"of few words\"},{\"id\":\"of_one%27s_word\",\"text\":\"of one's word\"},{\"id\":\"put_something_into_words\",\"text\":\"put something into words\"},{\"id\":\"put_words_into_someone%27s_mouth\",\"text\":\"put words into someone's mouth\"},{\"id\":\"spread_the_word\",\"text\":\"spread the word\"},{\"id\":\"take_someone_at_their_word\",\"text\":\"take someone at their word\"},{\"id\":\"take_someone%27s_word\",\"text\":\"take someone's word\"},{\"id\":\"take_the_words_out_of_someone%27s_mouth\",\"text\":\"take the words out of someone's mouth\"},{\"id\":\"the_Word\",\"text\":\"the Word\"},{\"id\":\"the_word_on_the_street\",\"text\":\"the word on the street\"},{\"id\":\"too_%E2%80%94_for_words\",\"text\":\"too — for words\"},{\"id\":\"waste_words\",\"text\":\"waste words\"},{\"id\":\"word_for_word\",\"text\":\"word for word\"},{\"id\":\"word_gets_around\",\"text\":\"word gets around\"},{\"id\":\"word_of_honour\",\"text\":\"word of honour\"},{\"id\":\"word_of_mouth\",\"text\":\"word of mouth\"},{\"id\":\"words_fail_me\",\"text\":\"words fail me\"}],\"text\":\"word\"},{\"derivatives\":[{\"id\":\"wordage\",\"text\":\"wordage\"}],\"entries\":[{\"pronunciations\":[{\"audioFile\":\"https://audio.oxforddictionaries.com/en/mp3/whirred__gb_1.mp3\",\"dialects\":[\"British English\"],\"phoneticNotation\":\"IPA\",\"phoneticSpelling\":\"wəːd\"}],\"senses\":[{\"definitions\":[\"used to express agreement or affirmation\"],\"examples\":[{\"text\":\"Word, that's a good record, man\"}],\"id\":\"m_en_gbus1167030.050\",\"registers\":[{\"id\":\"informal\",\"text\":\"Informal\"}],\"shortDefinitions\":[\"used to express agreement or affirmation\"]}]}],\"language\":\"en-gb\",\"lexicalCategory\":{\"id\":\"interjection\",\"text\":\"Interjection\"},\"phrasalVerbs\":[{\"id\":\"word_up\",\"text\":\"word up\"}],\"phrases\":[{\"id\":\"a_word_to_the_wise\",\"text\":\"a word to the wise\"},{\"id\":\"at_a_word\",\"text\":\"at a word\"},{\"id\":\"be_as_good_as_one%27s_word\",\"text\":\"be as good as one's word\"},{\"id\":\"break_one%27s_word\",\"text\":\"break one's word\"},{\"id\":\"have_a_word\",\"text\":\"have a word\"},{\"id\":\"have_a_word_in_someone%27s_ear\",\"text\":\"have a word in someone's ear\"},{\"id\":\"in_a_word\",\"text\":\"in a word\"},{\"id\":\"in_other_words\",\"text\":\"in other words\"},{\"id\":\"in_so_many_words\",\"text\":\"in so many words\"},{\"id\":\"keep_one%27s_word\",\"text\":\"keep one's word\"},{\"id\":\"my_word\",\"text\":\"my word\"},{\"id\":\"of_few_words\",\"text\":\"of few words\"},{\"id\":\"of_one%27s_word\",\"text\":\"of one's word\"},{\"id\":\"put_something_into_words\",\"text\":\"put something into words\"},{\"id\":\"put_words_into_someone%27s_mouth\",\"text\":\"put words into someone's mouth\"},{\"id\":\"spread_the_word\",\"text\":\"spread the word\"},{\"id\":\"take_someone_at_their_word\",\"text\":\"take someone at their word\"},{\"id\":\"take_someone%27s_word\",\"text\":\"take someone's word\"},{\"id\":\"take_the_words_out_of_someone%27s_mouth\",\"text\":\"take the words out of someone's mouth\"},{\"id\":\"the_Word\",\"text\":\"the Word\"},{\"id\":\"the_word_on_the_street\",\"text\":\"the word on the street\"},{\"id\":\"too_%E2%80%94_for_words\",\"text\":\"too — for words\"},{\"id\":\"waste_words\",\"text\":\"waste words\"},{\"id\":\"word_for_word\",\"text\":\"word for word\"},{\"id\":\"word_gets_around\",\"text\":\"word gets around\"},{\"id\":\"word_of_honour\",\"text\":\"word of honour\"},{\"id\":\"word_of_mouth\",\"text\":\"word of mouth\"},{\"id\":\"words_fail_me\",\"text\":\"words fail me\"}],\"text\":\"word\"}],\"type\":\"headword\",\"word\":\"word\"}],\"word\":\"word\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, Entry.class);
    }

    private Search testSearch() throws JsonProcessingException {
        String result = "{\"metadata\":{\"limit\":\"50\",\"offset\":\"0\",\"operation\":\"search\",\"provider\":\"Oxford University Press\",\"schema\":\"WordList\",\"sourceLanguage\":\"en-gb\",\"total\":\"38\"},\"results\":[{\"id\":\"word\",\"label\":\"word\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"word\"},{\"id\":\"word_for_word\",\"label\":\"word for word\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"word for word\"},{\"id\":\"wording\",\"label\":\"wording\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"wording\"},{\"id\":\"wordplay\",\"label\":\"wordplay\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"wordplay\"},{\"id\":\"wordy\",\"label\":\"wordy\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"wordy\"},{\"id\":\"work\",\"label\":\"work\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work\"},{\"id\":\"work_on_someone\",\"label\":\"work on someone\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work on someone\"},{\"id\":\"work_out\",\"label\":\"work out\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work out\"},{\"id\":\"work_someone_over\",\"label\":\"work someone over\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work someone over\"},{\"id\":\"work_something_out\",\"label\":\"work something out\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work something out\"},{\"id\":\"work_something_up\",\"label\":\"work something up\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"work something up\"},{\"id\":\"workable\",\"label\":\"workable\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workable\"},{\"id\":\"workaday\",\"label\":\"workaday\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workaday\"},{\"id\":\"worker\",\"label\":\"worker\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worker\"},{\"id\":\"workforce\",\"label\":\"workforce\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workforce\"},{\"id\":\"working\",\"label\":\"working\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"working\"},{\"id\":\"workman\",\"label\":\"workman\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workman\"},{\"id\":\"workmanlike\",\"label\":\"workmanlike\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workmanlike\"},{\"id\":\"workmanship\",\"label\":\"workmanship\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workmanship\"},{\"id\":\"workout\",\"label\":\"workout\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workout\"},{\"id\":\"workshop\",\"label\":\"workshop\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"workshop\"},{\"id\":\"world\",\"label\":\"world\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"world\"},{\"id\":\"worldly\",\"label\":\"worldly\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worldly\"},{\"id\":\"worldly-wise\",\"label\":\"worldly-wise\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worldly-wise\"},{\"id\":\"worldwide\",\"label\":\"worldwide\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worldwide\"},{\"id\":\"worn\",\"label\":\"worn\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worn\"},{\"id\":\"worn_out\",\"label\":\"worn out\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worn out\"},{\"id\":\"worried\",\"label\":\"worried\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worried\"},{\"id\":\"worrisome\",\"label\":\"worrisome\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worrisome\"},{\"id\":\"worry\",\"label\":\"worry\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worry\"},{\"id\":\"worrying\",\"label\":\"worrying\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worrying\"},{\"id\":\"worsen\",\"label\":\"worsen\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worsen\"},{\"id\":\"worship\",\"label\":\"worship\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worship\"},{\"id\":\"worst\",\"label\":\"worst\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worst\"},{\"id\":\"worth\",\"label\":\"worth\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worth\"},{\"id\":\"worthless\",\"label\":\"worthless\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worthless\"},{\"id\":\"worthwhile\",\"label\":\"worthwhile\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worthwhile\"},{\"id\":\"worthy\",\"label\":\"worthy\",\"matchString\":\"wor\",\"matchType\":\"headword\",\"region\":\"gb\",\"word\":\"worthy\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, Search.class);
    }
}
