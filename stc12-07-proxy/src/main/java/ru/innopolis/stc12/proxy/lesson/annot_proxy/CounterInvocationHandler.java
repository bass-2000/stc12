package ru.innopolis.stc12.proxy.lesson.annot_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CounterInvocationHandler implements InvocationHandler {
    private Counter counter;

    public CounterInvocationHandler(Counter counter) {
        this.counter = counter;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = counter.getClass();
        if (counter.getClass().getAnnotation(Logged.class) != null) {
            long startTime = System.currentTimeMillis();
            System.out.println("We call method + " + method.getName());
            Object result = method.invoke(counter, args);
            System.out.println(" with time, " + (System.currentTimeMillis() - startTime));
            return result;
        } else {
            return method.invoke(counter, args);

        }
    }
}

