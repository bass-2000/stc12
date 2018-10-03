package ru.innopolis.stc12.logger;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Simple {
    static final Logger logger = Logger.getLogger(Simple.class);
    public static void main(String[] args) {
        logger.warn("ATTENCION!");
        try {
            System.setErr(new PrintStream(new FileOutputStream("errLog.log")));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        logger.info("AttaTa");
    }
}
