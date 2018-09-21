package ru.innopolis.stc12.logger.log4j;

import org.apache.log4j.Logger;

public class SomeClass {
    private static Logger LOGGER = Logger.getLogger(SomeClass.class);

    public SomeClass() {
        LOGGER.warn("Warn from SomeClass");
        LOGGER.info("INFO from some class");
    }
}
