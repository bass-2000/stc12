package ru.innopolis.stc12.proxy;

import org.apache.log4j.Logger;

import java.util.*;

@Logging
public class MathBox<T extends Number> implements MathBoxInterface {
    private static Logger logger = Logger.getLogger(MathBox.class);
    private TreeSet<T> enterSet;

    /**
     * Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно),
     * являющуюся полем MathBox. Элементы должны отсортироваться
     *
     * @param args Конструктор на вход получает массив Integer. Элементы не могут повторяться
     */
    public MathBox(T[] args) {
        List<T> list = Arrays.asList(args);
        this.enterSet = new TreeSet<>(list);
    }

    public MathBox(List<T> list) {
        this.enterSet = new TreeSet<>(list);
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
        for (T num : enterSet) {
            result += num.intValue();
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
    public Set<Integer> splitter(int divider) {
        Set<Integer> result = new TreeSet<>();
        for (T num : enterSet) {
            result.add((num).intValue() / divider);
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
    public Set<T> predator(int numToDel) {
        TreeSet<T> result = new TreeSet<>();
        for (T num : enterSet) {
            if (num.intValue() != numToDel) result.add(num);
            else logger.info("ATTENTION!!!\nОбнаружено число " + numToDel + " в массиве на удаление.\n");
        }
        enterSet = result;
        return result;
    }

}

