package ru.innopolis.stc12.multithread;

public class WaitAndPrint implements Runnable {
    private final int period;
    private String message;
    private Thread t = new Thread(this);

    WaitAndPrint(int period, String message) {
        this.period = period;
        this.message = message;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true)
                synchronized (Message.class) {
                    Message.class.wait();
                    if (Message.count % period == 0)
                        Message.sendMessage(message);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}