package ru.innopolis.stc12.proxy.lesson.annot_proxy;

import org.apache.log4j.Logger;

@Logged
public class MathCounter implements Counter {
    private static Logger logger = Logger.getLogger(MathCounter.class);
    public void count() {
        logger.info("Counting...");
    }
}
