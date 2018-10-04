package ru.innopolis.stc12.proxy.lesson.annot_proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CounterInvocationHandler implements InvocationHandler {
    private Counter counter;
    private static Logger logger = Logger.getLogger(CounterInvocationHandler.class);
    public CounterInvocationHandler(Counter counter) {
        this.counter = counter;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = counter.getClass();
        if (counter.getClass().getAnnotation(Logged.class) != null) {
            long startTime = System.currentTimeMillis();
            logger.info("We call method + " + method.getName());
            Object result = method.invoke(counter, args);
            logger.info(" with time, " + (System.currentTimeMillis() - startTime));
            return result;
        } else {
            return method.invoke(counter, args);

        }
    }
}

