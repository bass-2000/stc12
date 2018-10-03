package ru.innopolis.stc12.logger.log4j;

import org.apache.log4j.Logger;

public class Main {
    static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("debug-message");
        LOGGER.info("info-message");
        LOGGER.warn("warn-message");
        LOGGER.error("error-message");
        LOGGER.fatal("fatal-message");
//        for(int i =0; i<10000000; i++){
//            LOGGER.info("msg");
//        }
        try {
            throw new Exception("test Exception");
        } catch (Exception e) {
            LOGGER.error(e);
        }

        SomeClass someClass = new SomeClass();
    }
}
