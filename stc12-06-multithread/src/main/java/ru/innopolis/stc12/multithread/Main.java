package ru.innopolis.stc12.multithread;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Chronometer());
        thread.start();
        new WaitAndPrint(5, "Прошло 5 секунд!");
        new WaitAndPrint(7, "Прошло 7 секунд!");

    }
}
