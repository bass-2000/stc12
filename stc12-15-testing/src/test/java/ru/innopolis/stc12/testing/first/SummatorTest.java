package ru.innopolis.stc12.testing.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SummatorTest {
    private Summator summator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is @BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("This is @BeforeEach");
        summator = new Summator();
    }

    @Test
    void sumTest() {
        int sum = this.summator.sum(2, 3);
        Assertions.assertEquals(5, sum);
    }

    @Test
    void doSomeTest() {
        Assertions.assertThrows(IOException.class, () -> summator.doSome(5));
    }
}
