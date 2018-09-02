package ru.innopolis.stc12.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.TreeSet;

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
                Field enterSet = mathB.getClass().getDeclaredField("enterSet");
                enterSet.setAccessible(true);
                enterSet.set(mathB, new TreeSet<Integer>());
                System.out.println("Data was cleared");
            }

        }
        return method.invoke(mathB, args);
    }
}
