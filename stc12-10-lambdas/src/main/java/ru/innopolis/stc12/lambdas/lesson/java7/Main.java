package ru.innopolis.stc12.lambdas.lesson.java7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свою зарплату");
        final Integer salary = scanner.nextInt();
        System.out.println("Введите страну");
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
