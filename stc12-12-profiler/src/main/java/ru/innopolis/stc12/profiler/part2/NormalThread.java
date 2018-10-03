package ru.innopolis.stc12.profiler.part2;

import org.apache.log4j.Logger;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class NormalThread implements Runnable {
    private static Logger logger = Logger.getLogger(NormalThread.class);
    private int period = 100;
    private int increment = 5000;
    private int threshold = 2000;
    private ArrayList<SomePojo> leakableCollection;
    private boolean stopTime = false;

    public NormalThread(int period, int increment, int threshold) {
        this.period = period;
        this.increment = increment;
        this.threshold = threshold;
        this.leakableCollection = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!stopTime) {
            int j = 0;
            try {
                sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < increment; i++) {
                SomePojo somePojo = new SomePojo();
                somePojo = null;
                leakableCollection.add(somePojo);
                j++;
            }
            logger.info("Thread " + Thread.currentThread().getName() + " collize: " + leakableCollection.size());
        }

    }
}
