package ru.innopolis.stc12.testing.first;

import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Summator summator = new Summator();
        logger.info(summator.sum(1, 2));
    }
}
