package ru.innopolis.stc12.profiler.part2;

import java.util.Random;

public class SomePojo {
    final Random random = new Random();
    private Integer a;
    private String b;
    private Object o;

    public SomePojo() {
        a = random.nextInt();
        b = String.valueOf(random.nextInt());
        o = random.nextInt();
    }

    @Override
    public String toString() {
        return "SomePojo{" +
                "random=" + random +
                ", a=" + a +
                ", b='" + b + '\'' +
                ", o=" + o +
                '}';
    }
}
