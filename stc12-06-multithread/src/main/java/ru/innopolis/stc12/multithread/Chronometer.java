package ru.innopolis.stc12.multithread;


import org.apache.log4j.Logger;

public class Chronometer implements Runnable {
    private int count;
    private int loopCount = 0;
    private Logger logger = Logger.getLogger(Chronometer.class);

    int getCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            while (loopCount < 1000000) {
                Thread.sleep( 1000);
                synchronized (Message.class) {
                    count = ++Message.count;
                    Message.sendMessage("C момента запуска прошло :" + Integer.toString(count) + " секунд", logger);
                    Message.class.notifyAll();
                    loopCount++;
                }
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}