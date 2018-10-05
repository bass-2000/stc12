package ru.innopolis.stc12.testing.third;

import java.net.URL;
import java.util.Set;

public interface WordFinder {
    Set<String> getSentences(URL sourcs);

    boolean checkInWordInSentence(String sentence, String word);

    void writeSentenceToResult(String sentence);
}
