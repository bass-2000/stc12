package ru.innopolis.stc12.testing.third;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WordFinderIml implements WordFinder {

    @Override
    public Set<String> getSentences(URL sourcs) {
        return new HashSet<>();
    }

    @Override
    public boolean checkInWordInSentence(String sentence, String word) {
        return false;
    }

    @Override
    public void writeSentenceToResult(String sentence) {
        //we made an empty method
    }
}
