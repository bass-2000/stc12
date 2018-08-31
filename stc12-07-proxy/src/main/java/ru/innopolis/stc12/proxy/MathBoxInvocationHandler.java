package ru.innopolis.stc12.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxInvocationHandler<Integer> implements InvocationHandler {
    MathBoxInterface<Integer> mathB;

    public MathBoxInvocationHandler(MathBoxInterface<Integer> mathBox) {
        mathB = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (mathB.getClass().isAnnotationPresent(Logger.class)) {
            System.out.println("Logging: Method " + method.getName() + " is running");
        }
        Method[] methods = mathB.getClass().getMethods();
        for (Method m : methods) {
            if (method.getName().equals(m.getName()) && m.getAnnotation(ClearData.class) != null) {
                System.out.println("Container cleared");
                return method.invoke(mathB, args);
            } else {
                return method.invoke(mathB, args);
            }
        }
        return method.invoke(mathB, args);
    }
}
