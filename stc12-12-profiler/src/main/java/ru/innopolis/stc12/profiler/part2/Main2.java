package ru.innopolis.stc12.profiler.part2;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        Thread largeThread = new Thread(new NormalThread(100, 20000));
        Thread mediumThread = new Thread(new NormalThread(100, 5000));
        Thread smallThread = new Thread(new NormalThread(100, 1000));
        threads.add(largeThread);
        threads.add(mediumThread);
        threads.add(smallThread);

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
