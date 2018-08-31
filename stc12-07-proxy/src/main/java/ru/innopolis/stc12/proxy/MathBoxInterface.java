package ru.innopolis.stc12.proxy;

import java.util.Collection;
import java.util.TreeSet;

public interface MathBoxInterface<T> {

    int summator();

    TreeSet<T> splitter(int divider);
    TreeSet<T> predator(int numToDel);
}
