package ru.innopolis.stc12.logger.jul;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("LALALALALLALALALA");
        logger.log(Level.INFO, "Testing logger");
        logger.logp(Level.INFO, "Main", "main", "message text");


        try {
            FileHandler fileHandler = new FileHandler("JulLog.log");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "msg");
        }


        logger.logp(Level.INFO, "Main", "main", "Some message");
        logger.getHandlers()[0].setLevel(Level.FINE);
        logger.logp(Level.FINE, "Main", "main", "Some message");
    }
}
