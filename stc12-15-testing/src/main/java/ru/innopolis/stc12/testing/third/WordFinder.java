package ru.innopolis.stc12.testing.third;

import java.net.URL;
import java.util.HashSet;

public interface WordFinder {
    HashSet<String> getSentences(URL sourcs);

    boolean checkInWordInSentence(String sentence, String word);

    void writeSentenceToResult(String sentence);
}
