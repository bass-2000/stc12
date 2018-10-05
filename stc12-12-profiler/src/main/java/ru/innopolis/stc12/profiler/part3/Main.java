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
        str1 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

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
