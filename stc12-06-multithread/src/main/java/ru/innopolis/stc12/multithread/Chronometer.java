package ru.innopolis.stc12.multithread;

public class Chronometer implements Runnable {
    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep( 1000);
                synchronized (Message.class) {
                    count = ++Message.count;
                    Message.sendMessage("C момента запуска прошло :" + Integer.toString(count) + " секунд");
                    Message.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}