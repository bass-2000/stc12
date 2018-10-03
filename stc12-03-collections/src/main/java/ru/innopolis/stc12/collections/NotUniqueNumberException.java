package ru.innopolis.stc12.collections;


import org.apache.log4j.Logger;

public class NotUniqueNumberException extends Exception {
    private static Logger logger = Logger.getLogger(NotUniqueNumberException.class);
    public NotUniqueNumberException(int num) {
        logger.error("NotUniqueNumber: " + num);
    }
}
