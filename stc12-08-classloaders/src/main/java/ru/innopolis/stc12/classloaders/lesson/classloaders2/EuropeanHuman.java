package ru.innopolis.stc12.classloaders.lesson.classloaders2;

import org.apache.log4j.Logger;

public class EuropeanHuman implements Human {
    private static Logger logger = Logger.getLogger(EuropeanHuman.class);
    @Override
    public void eat(String what, int howMany) {
        logger.info("Omnomnom " + what + " count " + howMany);
    }

    @Override
    public void sleep(int duration) {
        logger.info("HHRRRRRR " + duration + " hours");
    }

    @Override
    public String saySmth() {
        return "I'm not from London";
    }
}
