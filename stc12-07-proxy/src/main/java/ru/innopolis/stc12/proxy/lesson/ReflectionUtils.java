package ru.innopolis.stc12.proxy.lesson;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static void printClass(Class clazz){
        printFields(clazz);
        System.out.println();
        printDeclaredFields(clazz);
        System.out.println();
        printMethods(clazz);
    }

    private static void printMethods(Class clazz){
        System.out.println("Class " + clazz.getMethods() + " getFields");
        methodIterator(clazz.getMethods());
    }

    private static void methodIterator(Method[] methods){
        for (Method method: methods){
            System.out.println("Name " + method.getName());
            System.out.println("type " + method.getReturnType().getName());
            System.out.println("Parameters: ");
            System.out.println();
            for(Class parameterClass: method.getParameterTypes()){
                System.out.println(parameterClass.getName() + " , "  );
            }
        }
    }

    public static void printFields(Class clazz){
        System.out.println("Class " + clazz.getName() + " getFields");
        fieldIterator(clazz.getFields());
    }

    public static void printDeclaredFields(Class clazz){
        System.out.println("Class " + clazz.getName() + " getFields");
        fieldIterator(clazz.getDeclaredFields());
    }

    private static void fieldIterator(Field[] fields){
        for(Field field: fields){
            System.out.println("name " + field.getName() + " type " + field.getType().getCanonicalName());
            System.out.println("modifier: " + field.getModifiers());
        }
    }
}
