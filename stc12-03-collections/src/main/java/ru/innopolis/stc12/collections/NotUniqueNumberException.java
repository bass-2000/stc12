package ru.innopolis.stc12.collections;


public class NotUniqueNumberException extends Exception {
    public NotUniqueNumberException(int num) {
        System.out.println("NotUniqueNumber: " + num);
    }
}
