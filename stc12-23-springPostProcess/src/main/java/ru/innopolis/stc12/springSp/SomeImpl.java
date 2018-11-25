package ru.innopolis.stc12.springSp;

import javax.annotation.PostConstruct;

@Profiling
public class SomeImpl implements Some {
    @RandomInt(min = 1, max = 5)
    private int repeat;
    private String text = "Some text";

    public SomeImpl() {
        System.out.println("Random from constructor = " + repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Random from postConstruct = " + repeat);
    }

    @Override
    public void doSome() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < repeat; i++) {

            System.out.println(text);
        }
    }
}
