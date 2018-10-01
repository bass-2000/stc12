package ru.innopolis.stc12.multithread;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class multithreadTest {
    private Logger logger = Logger.getLogger(multithreadTest.class);
    @Test
    public void chronometer() {
        BasicConfigurator.configure();
        Chronometer chronometer = new Chronometer();
        Thread thread = new Thread(chronometer);
        thread.start();
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        thread.isInterrupted();
        Assertions.assertTrue(chronometer.getCount() > 0);
    }

}
