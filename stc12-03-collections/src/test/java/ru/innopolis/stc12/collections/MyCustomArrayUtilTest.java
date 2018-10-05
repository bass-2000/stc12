package ru.innopolis.stc12.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyCustomArrayUtilTest {


    @Test
    void generateArray() {
        int len = 10;
        int[] array = MyCustomArrayUtil.generateArray(len);
        Assertions.assertEquals(len, array.length);
        for (int i : array) {
            Assertions.assertNotNull(i);
        }
    }

    @Test
    void generateArrayList() {
        int len = 10;
        List<Integer> list = MyCustomArrayUtil.generateArrayList(len);
        Assertions.assertEquals(len, list.size());
        for (int i : list) {
            Assertions.assertNotNull(i);
        }
    }

    @Test
    void arrayUniqueCheckerList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(5);
        Assertions.assertThrows(NotUniqueNumberException.class, () -> MyCustomArrayUtil.arrayUniqueChecker(list));
    }

    @Test
    void arrayUniqueCheckerArray() {
        int[] array = new int[]{1, 3, 4, 4, 5};
        Assertions.assertThrows(NotUniqueNumberException.class, () -> MyCustomArrayUtil.arrayUniqueChecker(array));
    }

    @Test
    void intArrayToIntegerConverter() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        Integer[] result = MyCustomArrayUtil.intArrayToIntegerConverter(array);
        for (int i = 0; i < array.length; i++) {
            Assertions.assertTrue(array[i] == result[i]);
        }
    }
}