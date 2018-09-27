package ru.innopolis.stc12.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.TreeSet;

public class MathBoxInvocationHandler<T> implements InvocationHandler {
    MathBoxInterface<T> mathB;

    public MathBoxInvocationHandler(MathBoxInterface<T> mathBox) {
        mathB = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (mathB.getClass().isAnnotationPresent(Logger.class)) {
            System.out.println("Logging: Method " + method.getName() + " is running");
        }
        Method[] methods = mathB.getClass().getMethods();
        for (Method m : methods) {
            if (method.getName().equals(m.getName()) && (method.getParameters().getClass().equals(m.getParameters().getClass())) && m.getAnnotation(ClearData.class) != null) {
                Field enterSet = mathB.getClass().getDeclaredField("enterSet");
                enterSet.setAccessible(true);
                enterSet.set(mathB, new TreeSet<T>());
                System.out.println("Data was cleared");
            }

        }
        return method.invoke(mathB, args);
    }
}
