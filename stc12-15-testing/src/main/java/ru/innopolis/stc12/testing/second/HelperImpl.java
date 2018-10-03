package ru.innopolis.stc12.testing.second;

import org.apache.log4j.Logger;

public class HelperImpl implements Helper {
    private static Logger logger = Logger.getLogger(HelperImpl.class);
    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return (a + b) * 2;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        logger.info((a + b) * 2);
    }
}
