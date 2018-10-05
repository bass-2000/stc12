package ru.innopolis.stc12.proxy.lesson;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Capucin abou = new Capucin(59);
        Class<Capucin> clazz = (Class<Capucin>) abou.getClass();
        logger.info(abou);
        logger.info(clazz);
        Capucin mrJenkins = new Capucin();
        Field footSizeField = mrJenkins.getClass().getDeclaredField("footSize");
        footSizeField.setAccessible(true);
        logger.info(footSizeField.get(mrJenkins));
        footSizeField.set(mrJenkins, 33);
        logger.info(footSizeField.get(mrJenkins));

        Field tailLengthField = mrJenkins.getClass().getDeclaredField("tailLength");
        tailLengthField.setAccessible(true);
        tailLengthField.set(mrJenkins,1000);
        logger.info(tailLengthField.get(mrJenkins));
    }
}
