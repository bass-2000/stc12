package ru.innopolis.stc12.logger.log4j;

import org.apache.log4j.Logger;

public class Main {
    static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("debug-message");
        logger.info("info-message");
        logger.warn("warn-message");
        logger.error("error-message");
        logger.fatal("fatal-message");
        for (int i = 0; i < 10000000; i++) {
            logger.info("msg");
        }
        try {
            throw new Exception("test Exception");
        } catch (Exception e) {
            logger.error(e);
        }

    }
}
