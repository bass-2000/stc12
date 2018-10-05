package ru.innopolis.stc12.testing.third;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

class WordFinderUser {
    private WordFinder wordFinder;

    WordFinderUser(WordFinder wordFinder) {
        this.wordFinder = wordFinder;
    }

    void doWork(String resource, String word) throws MalformedURLException {
        HashSet<String> sentences = wordFinder.getSentences(new URL(resource));
        for (String sentence : sentences) {
            if (wordFinder.checkInWordInSentence(word, sentence)) wordFinder.writeSentenceToResult(sentence);
        }
    }
}
