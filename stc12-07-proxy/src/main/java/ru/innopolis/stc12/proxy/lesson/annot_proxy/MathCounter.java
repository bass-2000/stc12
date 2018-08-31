package ru.innopolis.stc12.proxy.lesson.annot_proxy;
@Logged
public class MathCounter implements Counter {

    public void count() {
        System.out.println("Counting...");
    }
}
