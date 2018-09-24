package ru.innopolis.stc12.testing.first;

import java.io.IOException;

public class Summator {

    public int sum(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public void doSome(int arg) throws IOException {
        if (arg == 5) {
            throw new IOException();
        }
    }
}
