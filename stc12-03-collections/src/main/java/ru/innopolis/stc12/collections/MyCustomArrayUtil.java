package ru.innopolis.stc12.collections;

import java.util.*;

public class MyCustomArrayUtil {
    /**
     * Генератор массива с уникальными значениями
     *
     * @param size - размер массива
     * @return возвращает необходимый массив элементов
     */
    public static int[] generateArray(int size) {
        int rnd;

        Random rand = new Random();
        int[] nums = new int[size];
        boolean[] check = new boolean[size * 10];
        for (int k = 0; k < size; k++) {
            rnd = rand.nextInt(size * 10);

            //цикл на случай если число уже есть такое
            while (check[rnd]) {
                rnd = rand.nextInt(size);
            }
            //Устанавливает рандомное число в слот
            nums[k] = rnd;
            check[rnd] = true;

        }

        return nums;
    }

    public static List<Integer> generateArrayList(int n) {
        List<Integer> arrayRandom = new ArrayList<Integer>(n);

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            Integer r = rand.nextInt(100);
            while (arrayRandom.contains(r)) {
                r = rand.nextInt(100);
            }
            arrayRandom.add(r);
        }
        return arrayRandom;
    }

    /**
     * Метод проверяет массив на уникальность элементов. Иначе кидает эксепшен, который мы в мейне отлавливаем
     *
     * @param arr - массив для проверки
     * @throws Exception Предупреждение о том, что в массиве присутствует неуникальный элемент и он выводится после двоеточия
     */
    public static void arrayUniqueChecker(int[] arr) throws Exception {
        Set<Integer> foundNumbers = new HashSet<Integer>();
        for (int num : arr) {
            if (foundNumbers.contains(num)) {
                throw new Exception("not unique number:" + num);
            }
            foundNumbers.add(num);
        }
    }

    /**
     * Метод проверяет массив на уникальность элементов. Иначе кидает эксепшен, который мы в мейне отлавливаем
     *
     * @param list - массив для проверки
     * @throws Exception Предупреждение о том, что в массиве присутствует неуникальный элемент и он выводится после двоеточия
     */
    public static void arrayUniqueChecker(List<Integer> list) throws Exception {
        Set<Integer> foundNumbers = new HashSet<Integer>();
        for (int num : list) {
            if (foundNumbers.contains(num)) {
                throw new Exception("not unique " + num);
            }
            foundNumbers.add(num);
        }
    }

    /**
     * Конвентрирует int[] массив в Integer[] массив
     *
     * @param arr int[] массив
     * @return Integer[] массив
     */
    public static Integer[] intArrayToIntegerConverter(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }
}
