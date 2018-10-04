package ru.innopolis.stc12.proxy.lesson;

import org.apache.log4j.Logger;

public abstract class Monkey {
    private String name;
    private Integer age;
    private String country;
    private String subType;

    private final int numLegs = 2;
    private static Logger logger = Logger.getLogger(Monkey.class);
    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private void saySomething(String smthg){
        logger.info(smthg);
    }
}
