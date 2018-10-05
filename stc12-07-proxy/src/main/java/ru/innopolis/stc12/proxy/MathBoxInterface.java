package ru.innopolis.stc12.proxy;

import java.util.Set;

public interface MathBoxInterface<T> {

    int summator();

    Set<Integer> splitter(int divider);

    Set<T> predator(int numToDel);
}
