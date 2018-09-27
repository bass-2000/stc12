package ru.innopolis.stc12.collections;


import java.util.List;


public class Main {


    public static void main(String[] args) {
        int size = 5;
        solutionViaArray(size);
        System.out.println("---------------------------------");
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
            System.out.println(e);
        }
        Integer[] inputArray = MyCustomArrayUtil.intArrayToIntegerConverter(inputNumbers);

        System.out.println("Выводим нагенерённый массив размером " + inputArray.length + " элементов: ");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }

        MathBox mathBox = new MathBox(inputArray);
        System.out.println("\nВыводим toString:");
        System.out.println(mathBox);

        System.out.println("Выводим summator:");
        System.out.println(mathBox.summator());

        System.out.println("Выводим splitter:");
        System.out.println(mathBox.splitter(2));

        System.out.println("Выводим predator:");
        System.out.println(mathBox.predator(10));
    }

    /**
     * решение через списочный массив ArrayList
     *
     * @param size размер массива
     */
    public static void solutionViaArrayList(int size) {
        List<Integer> list = MyCustomArrayUtil.generateArrayList(size);
        System.out.println("Выводим нагенерённый списочный массив размером " + list.size() + " элементов: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        try {
            MyCustomArrayUtil.arrayUniqueChecker(list);
        } catch (Exception e) {
            System.out.println(e);
        }


        MathBox mathBox = new MathBox(list);

        System.out.println("\nВыводим toString:");
        System.out.println(mathBox);

        System.out.println("Выводим summator:");
        System.out.println(mathBox.summator());

        System.out.println("Выводим splitter:");
        System.out.println(mathBox.splitter(2));

        System.out.println("Выводим predator:");
        System.out.println(mathBox.predator(10));
    }
}
