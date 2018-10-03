package ru.innopolis.stc12.testing.bad;


import org.apache.log4j.Logger;

public class Helper implements ru.innopolis.stc12.testing.second.Helper {
    private static Logger logger = Logger.getLogger(Helper.class);
    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return (a + b) * 2;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        logger.info((a + b) * 2);
    }
}
