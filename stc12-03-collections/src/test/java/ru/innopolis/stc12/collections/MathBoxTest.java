package ru.innopolis.stc12.collections;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

class MathBoxTest {
    private static Logger logger = Logger.getLogger(MathBoxTest.class);
    private static MathBox mathBox;
    private List<Integer> list;

    @BeforeAll
    static void setUp() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        mathBox = new MathBox(list);
    }

    @Test
    void summatorTest() {
        Assertions.assertEquals(mathBox.summator(), 9);
    }

    @Test
    void toStringTest() {
        String expected = "MathBox{enterSet=[1, 3, 5]}";
        Assertions.assertEquals(mathBox.toString(), expected);
    }

    @Test
    void predatorTest() {
        int numToDel = 3;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(5);
        Set<Integer> expected = new TreeSet<>(list1);
        Assertions.assertEquals(mathBox.predator(numToDel), expected);
    }

    @Test
    void equalsTest() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        MathBox mathBox1 = new MathBox(list1);
        Assertions.assertEquals(mathBox, mathBox1);
    }

    @Test
    void splitterTest() {
        int divider = 2;
        Integer[] args = {0, 1, 2};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(args));
        Assertions.assertEquals(mathBox.splitter(divider), expected);
    }

    @Test
    void mathBoxTest() {
        Integer[] array = {5, 1, 2, 4};
        MathBox mathBox1 = new MathBox(array);
        String expected = "MathBox{enterSet=[1, 2, 4, 5]}";
        Assertions.assertEquals(mathBox1.toString(), expected);
    }

    @Test
    void hashCodeTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        int expected = Objects.hash(new TreeSet(list));
        Assertions.assertEquals(mathBox.hashCode(), expected);
    }

}