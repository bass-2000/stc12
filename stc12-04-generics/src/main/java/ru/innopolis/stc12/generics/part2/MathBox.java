package ru.innopolis.stc12.generics.part2;

import org.apache.log4j.Logger;

import java.util.*;

public class MathBox extends ObjectBox<Integer> {
    private Logger logger = Logger.getLogger(MathBox.class);
    /**
     * Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно),
     * являющуюся полем MathBox. Элементы должны отсортироваться
     *
     * @param args Конструктор на вход получает массив Integer. Элементы не могут повторяться
     */
    public MathBox(Integer[] args) {
        List<Integer> list = Arrays.asList(args);
        this.enterSet = new TreeSet<>(list);
    }

    public MathBox(List<Integer> list) {
        super(new TreeSet(list));
        this.enterSet = new TreeSet(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(logger, mathBox.logger);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), logger);
    }

    /**
     * Метод, возвращающий сумму всех элементов коллекции
     *
     * @return возвращающает сумму всех элементов коллекции
     */
    @Override
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
    @Override
    public Set<Integer> splitter(int divider) {
        Set<Integer> result = new TreeSet<>();
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
    public Set<Integer> predator(int numToDel) {
        Set<Integer> result = new TreeSet<>();
        for (int num : this.enterSet) {
            if (num != numToDel) result.add(num);
            else logger.info("ATTENTION!!!\nОбнаружено число " + numToDel + " в массиве на удаление.\n");
        }
        return result;
    }

}
