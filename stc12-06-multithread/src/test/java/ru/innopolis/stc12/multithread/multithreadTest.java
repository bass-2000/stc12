package ru.innopolis.stc12.multithread;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class multithreadTest {

    @Test
    public void chronometer() {
        Chronometer chronometer = new Chronometer();
        Thread thread = new Thread(chronometer);
        thread.start();
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        thread.isInterrupted();
        Assertions.assertTrue(chronometer.getCount() > 0);
    }

}
