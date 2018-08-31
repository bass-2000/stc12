package ru.innopolis.stc12.proxy.lesson.annot_proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Counter realCounter = new MathCounter();
        Counter counterProxy = (Counter) Proxy.newProxyInstance(CounterInvocationHandler.class.getClassLoader(),new Class[]{Counter.class}, new CounterInvocationHandler(realCounter));
        counterProxy.count();
    }
}
