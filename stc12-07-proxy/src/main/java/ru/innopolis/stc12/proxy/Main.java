package ru.innopolis.stc12.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] inputNumbers = {10, 10, 34, 36, 17};
        Integer[] inputArray = Arrays.stream(inputNumbers).boxed().toArray(Integer[]::new);
        MathBoxInterface<Integer> mathBox = new MathBox(inputArray);

        MathBoxInterface<Integer> proxedMathBox = (MathBoxInterface<Integer>) Proxy.newProxyInstance(
                MathBoxInvocationHandler.class.getClassLoader(), new Class[]{MathBoxInterface.class}, new MathBoxInvocationHandler<Integer>(mathBox));

        System.out.println("MathBox method:");

        System.out.println(mathBox.summator());

        System.out.println(proxedMathBox.summator());

        System.out.println("MathBox method:");
        System.out.println(mathBox.toString());

        System.out.println(proxedMathBox.toString());

        proxedMathBox.predator(34);
        System.out.println(proxedMathBox);


    }
}
