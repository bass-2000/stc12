package ru.innopolis.stc12.testing.third;

import java.net.URL;
import java.util.HashSet;

public class WordFinderIml implements WordFinder {
    @Override
    public HashSet<String> getSentences(URL sourcs) {
        return null;
    }

    @Override
    public boolean checkInWordInSentence(String sentence, String word) {
        return false;
    }

    @Override
    public void writeSentenceToResult(String sentence) {

    }
}
