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
                taxCalc = new NonFuncTaxCalc() {
                    public double calculateTax(int summ) {
                        return summ * 0.13;
                    }

                };
            case "USA":
                taxCalc = new NonFuncTaxCalc() {
                    public double calculateTax(int summ) {
                        return summ * 0.13;
                    }
                };
        }
    }
}
