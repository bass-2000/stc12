package ru.innopolis.stc12.testing.third;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WordFinderUserTest {
    static final String FIRST_SENTENCE = "One";
    static final String SECOND_SENTENCE = "Two";
    static final String THIRD_SENTENCE = "Three";
    private static Logger logger = Logger.getLogger(WordFinderUserTest.class);
    private WordFinderUser wordFinderUser;
    private WordFinder wordFinder = Mockito.mock(WordFinder.class);

    @BeforeEach
    void prepareTest() {
        wordFinderUser = new WordFinderUser(wordFinder);
    }

    @Test
    void wordFinderEmptyList() {
        when(wordFinder.getSentences(any())).thenReturn(new HashSet<>());
        try {
            wordFinderUser.doWork("file://some", "word");
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
        verify(wordFinder, times(0)).checkInWordInSentence(any(), any());
        verify(wordFinder, times(0)).writeSentenceToResult(any());
    }

    @Test
    void wordFinderAllMatches() {
        when(wordFinder.getSentences(any())).thenReturn(new HashSet<>(
                Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE, THIRD_SENTENCE)));
        when(wordFinder.checkInWordInSentence(any(), any())).thenReturn(true);
        try {
            wordFinderUser.doWork("file://some", "word");
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
        verify(wordFinder, times(1)).writeSentenceToResult(FIRST_SENTENCE);
    }

    @Test
    void wordFinderNoMatches() {
        when(wordFinder.getSentences(any())).thenReturn(new HashSet<>(
                Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE, THIRD_SENTENCE)));
        when(wordFinder.checkInWordInSentence(any(), any())).thenReturn(false);
        try {
            wordFinderUser.doWork("file://some", "word");
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
        verify(wordFinder, times(0)).writeSentenceToResult(any());
    }
}