package ru.innopolis.stc12.profiler.part3;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        long startTime = System.currentTimeMillis();
        String str1;
        str1 = "gfsgdjlsdflsbdfjlsbdlkfbsdlvsldfksbdfklsbdfmbsdlfbsdlbflsbdlfbsdlfbsdfblsdkf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "gfsgdjlsdflsbdfjlsbdlkfbsdlvsldfksbdfklsbdfmbsdlfbsdlbflsbdlfbsdlfbsdfblsdkf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf" +
                "dajskfsdfsdfkjskdjfsjdkfbjksbdfjbsdfjbsjdfbjsbdfjsbdjfbsjdbfjsbdfjbsjdfbsjdf";

        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            newArray.add(str1.substring(0, 2).intern());
        }

        StringBuilder str = new StringBuilder();
        Random myRand = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            str.replace(0, str.capacity(), String.valueOf(myRand.nextInt()));
            str.append("Это - новое число");
            str.append(" которое было выведено на экран");
        }

        logger.info("Итог:");
        logger.info(System.currentTimeMillis() - startTime);
        logger.info(" мс");
        scanner.nextLine();
    }
}
