package ru.innopolis.stc12.classloaders.lesson.classloaders2;

import org.apache.log4j.Logger;

import java.lang.reflect.Proxy;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Human humanProxy = (Human) Proxy.newProxyInstance(EuropeanHuman.class.getClassLoader(),
                new Class[]{Human.class}, new HumanInvoker());
        logger.info(humanProxy.saySmth());
    }
}
