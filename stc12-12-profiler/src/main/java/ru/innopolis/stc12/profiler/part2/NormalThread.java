package ru.innopolis.stc12.profiler.part2;

import org.apache.log4j.Logger;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class NormalThread implements Runnable {
    private static Logger logger = Logger.getLogger(NormalThread.class);
    private int period = 100;
    private int increment = 5000;
    private ArrayList<SomePojo> leakableCollection;
    private boolean stopTime = false;

    public NormalThread(int period, int increment) {
        this.period = period;
        this.increment = increment;
        this.leakableCollection = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!stopTime) {
            try {
                sleep(period);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < increment; i++) {
                SomePojo somePojo = new SomePojo();
                logger.info(somePojo);
                somePojo = null;
                leakableCollection.add(somePojo);
            }
            logger.info("Thread " + Thread.currentThread().getName() + " collize: " + leakableCollection.size());
        }

    }
}
