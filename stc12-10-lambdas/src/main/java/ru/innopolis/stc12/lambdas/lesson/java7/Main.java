package ru.innopolis.stc12.lambdas.lesson.java7;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Введите свою зарплату");
        final Integer salary = scanner.nextInt();
        logger.info("Введите страну");
        scanner.nextLine();
        String country = scanner.nextLine();

        NonFuncTaxCalc taxCalc = null;
        switch (country) {
            case "Russia":
                taxCalc = summ -> summ * 0.13;
                break;
            case "USA":
                taxCalc = summ -> summ * 0.13;
                break;
            default:
        }
        logger.info(salary);
        logger.info(taxCalc != null ? taxCalc.calculateTax(salary) : 0);
    }
}
