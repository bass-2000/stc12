package ru.innopolis.stc12.proxy.lesson;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private static Logger logger = Logger.getLogger(ReflectionUtils.class);
    private ReflectionUtils() {
    }

    public static void printClass(Class clazz){
        printFields(clazz);
        logger.info("\n");
        printDeclaredFields(clazz);
        logger.info("\n");
        printMethods(clazz);
    }

    private static void printMethods(Class clazz){
        logger.info("Class " + clazz.getMethods() + " getFields");
        methodIterator(clazz.getMethods());
    }

    private static void methodIterator(Method[] methods){
        for (Method method: methods){
            logger.info("Name " + method.getName());
            logger.info("type " + method.getReturnType().getName());
            logger.info("Parameters: ");
            logger.info("\n");
            for(Class parameterClass: method.getParameterTypes()){
                logger.info(parameterClass.getName() + " , ");
            }
        }
    }

    public static void printFields(Class clazz){
        logger.info("Class " + clazz.getName() + " getFields");
        fieldIterator(clazz.getFields());
    }

    public static void printDeclaredFields(Class clazz){
        logger.info("Class " + clazz.getName() + " getFields");
        fieldIterator(clazz.getDeclaredFields());
    }

    private static void fieldIterator(Field[] fields){
        for(Field field: fields){
            logger.info("name " + field.getName() + " type " + field.getType().getCanonicalName());
            logger.info("modifier: " + field.getModifiers());
        }
    }
}
