package ru.innopolis.stc12.logger.log4j;

import org.apache.log4j.Logger;

public class SomeClass {
    private static Logger logger = Logger.getLogger(SomeClass.class);

    private SomeClass() {
        logger.warn("Warn from SomeClass");
        logger.info("INFO from some class");
    }
}
