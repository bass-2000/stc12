package ru.innopolis.stc12.collections;


import org.apache.log4j.Logger;

import java.util.List;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        int size = 5;
        solutionViaArray(size);
        logger.info("---------------------------------");
        solutionViaArrayList(size);

    }

    
    /**
     * Решение через обычный массив array[]
     *
     * @param size размер массива
     */
    public static void solutionViaArray(int size) {
        int[] inputNumbers = MyCustomArrayUtil.generateArray(size);
        //int[] inputNumbers = {10,10,34,36,17}; //для проверки дублей

        try {
            MyCustomArrayUtil.arrayUniqueChecker(inputNumbers);
        } catch (NotUniqueNumberException e) {
            logger.error(e.getMessage());
        }
        Integer[] inputArray = MyCustomArrayUtil.intArrayToIntegerConverter(inputNumbers);

        logger.info("Выводим нагенерённый массив размером " + inputArray.length + " элементов: ");
        for (int i : inputArray) {
            logger.info(i + " ");
        }

        MathBox mathBox = new MathBox(inputArray);
        logger.info("\nВыводим toString:");
        logger.info(mathBox);

        logger.info("Выводим summator:");
        logger.info(mathBox.summator());

        logger.info("Выводим splitter:");
        logger.info(mathBox.splitter(2));

        logger.info("Выводим predator:");
        logger.info(mathBox.predator(10));
    }

    /**
     * решение через списочный массив ArrayList
     *
     * @param size размер массива
     */
    public static void solutionViaArrayList(int size) {
        List<Integer> list = MyCustomArrayUtil.generateArrayList(size);
        logger.info("Выводим нагенерённый списочный массив размером " + list.size() + " элементов: ");
        for (int i : list) {
            logger.info(i + " ");
        }
        try {
            MyCustomArrayUtil.arrayUniqueChecker(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        MathBox mathBox = new MathBox(list);

        logger.info("\nВыводим toString:");
        logger.info(mathBox);

        logger.info("Выводим summator:");
        logger.info(mathBox.summator());

        logger.info("Выводим splitter:");
        logger.info(mathBox.splitter(2));

        logger.info("Выводим predator:");
        logger.info(mathBox.predator(10));
    }
}
