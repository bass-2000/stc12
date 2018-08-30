package ru.innopolis.stc12.multithread;

import org.junit.Assert;
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
        }
        thread.isInterrupted();
        Assert.assertTrue(chronometer.getCount()>0);
    }

}
