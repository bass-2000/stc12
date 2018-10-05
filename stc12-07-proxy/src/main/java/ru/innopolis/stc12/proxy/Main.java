package ru.innopolis.stc12.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        int[] inputNumbers = {10, 10, 34, 36, 17};
        Integer[] inputArray = Arrays.stream(inputNumbers).boxed().toArray(Integer[]::new);
        MathBoxInterface<Integer> mathBox = new MathBox(inputArray);

        MathBoxInterface<Integer> proxedMathBox = (MathBoxInterface<Integer>) Proxy.newProxyInstance(
                MathBoxInvocationHandler.class.getClassLoader(), new Class[]{MathBoxInterface.class}, new MathBoxInvocationHandler<Integer>(mathBox));

        logger.info("MathBox method: summator");

        logger.info(mathBox.summator());

        logger.info(proxedMathBox.summator());

        logger.info("MathBox method:");
        logger.info(mathBox.toString());

        logger.info(proxedMathBox.toString());

        proxedMathBox.predator(34);
        logger.info(proxedMathBox);


    }
}
