package ru.innopolis.stc12.proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

@Logger
public class MathBox<Integer> implements MathBoxInterface {
    private TreeSet<java.lang.Integer> enterSet;

    /**
     * Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно),
     * являющуюся полем MathBox. Элементы должны отсортироваться
     *
     * @param args Конструктор на вход получает массив Integer. Элементы не могут повторяться
     */
    public MathBox(java.lang.Integer args[]) {
        List<java.lang.Integer> list = Arrays.asList(args);
        this.enterSet = new TreeSet<java.lang.Integer>(list);
    }

    public MathBox(List<java.lang.Integer> list) {
        this.enterSet = new TreeSet<java.lang.Integer>(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(enterSet, mathBox.enterSet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(enterSet);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "enterSet=" + enterSet +
                '}';
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
    public TreeSet<java.lang.Integer> splitter(int divider) {
        TreeSet<java.lang.Integer> result = new TreeSet<java.lang.Integer>();
        for (int num : enterSet) {
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
    @ClearData
    public TreeSet<java.lang.Integer> predator(int numToDel) {
        TreeSet<java.lang.Integer> result = new TreeSet<java.lang.Integer>();
        for (int num : enterSet) {
            if (num != numToDel) result.add(num);
            else System.out.println("ATTENTION!!!\nОбнаружено число " + numToDel + " в массиве на удаление.\n");
        }
        enterSet = result;
        return result;
    }

}

