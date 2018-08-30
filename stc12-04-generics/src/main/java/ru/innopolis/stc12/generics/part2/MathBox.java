package ru.innopolis.stc12.generics.part2;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MathBox extends ObjectBox<Integer> {
    private TreeSet<Integer> enterSet;

    /**
     * Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно),
     * являющуюся полем MathBox. Элементы должны отсортироваться
     *
     * @param args Конструктор на вход получает массив Integer. Элементы не могут повторяться
     */
    public MathBox(Integer args[]) {
        List<Integer> list = Arrays.asList(args);
        this.enterSet = new TreeSet<Integer>(list);
    }

    public MathBox(List<Integer> list) {
        super(new TreeSet(list));
        this.enterSet = new TreeSet(list);
    }


    /**
     * Метод, возвращающий сумму всех элементов коллекции
     *
     * @return возвращающает сумму всех элементов коллекции
     */
    public int summator() {
        int result = 0;
        for (int num : enterSet) {
            result += num;
        }
        return result;
    }

    /**
     * выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
     * являющийся аргументом метода. Метод возвращает коллекцию с результатами деления.
     * Коллекция внутри класса при этом не меняется
     *
     * @param divider делитель
     * @return коллекция с результатом деления
     */
    public TreeSet<Integer> splitter(int divider) {
        TreeSet<Integer> result = new TreeSet<Integer>();
        for (int num : this.enterSet) {
            result.add(num / divider);
        }
        return result;
    }

    /**
     * метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его
     *
     * @param numToDel удаляемый из коллекции элемент(на самом деле он просто не включается в новую коллекцию)
     * @return коллекция с результатом
     */
    public TreeSet<Integer> predator(int numToDel) {
        TreeSet<Integer> result = new TreeSet<Integer>();
        for (int num : this.enterSet) {
            if (num != numToDel) result.add(num);
            else System.out.println("ATTENTION!!!\nОбнаружено число " + numToDel + " в массиве на удаление.\n");
        }
        return result;
    }

}
