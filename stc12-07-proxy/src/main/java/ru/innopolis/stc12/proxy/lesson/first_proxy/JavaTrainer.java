package ru.innopolis.stc12.proxy.lesson.first_proxy;

import org.apache.log4j.Logger;

public class JavaTrainer implements Trainer{
    private static Logger logger = Logger.getLogger(JavaTrainer.class);
    public void teach() {
        logger.info("Java is so complicated");
    }

    public void eat() {
        logger.info("I like to eat mango");
    }

    public void talk() {
        logger.info("Where's your homework?");
    }
}
