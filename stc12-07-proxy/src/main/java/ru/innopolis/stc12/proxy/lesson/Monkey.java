package ru.innopolis.stc12.proxy.lesson;

public abstract class Monkey {
    private String name;
    private Integer age;
    private String country;
    private String subType;

    private final int numLegs = 2;

    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private void saySomething(String smthg){
        System.out.println(smthg);
    }
}
