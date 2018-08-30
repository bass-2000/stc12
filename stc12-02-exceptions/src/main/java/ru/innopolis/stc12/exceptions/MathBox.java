package ru.innopolis.stc12.exceptions;


public class MathBox {
    /**
     * @param a first parameter
     * @param b second parameter
     * @return summary of params
     */
    public int summa(Integer a, Integer b) {
        return a + b;
    }

    /**
     * @param a first parameter
     * @param b second parameter
     * @return difference between two params
     */
    public int diff(Integer a, Integer b) {
        return a - b;
    }

    /**
     * @param value
     * @return factorial of value
     */
    public long factorial(Integer value) {
        if (value == 1 || value == 0) {
            return 1;
        }
        return factorial(value - 1) * value;
    }

    /**
     * @param a first parameter
     * @param b second parameter
     * @return dividing param a by b with catching Arithmetic Exception
     */
    public double dividerExceptionInside(Integer a, Integer b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Catched Exception " + e);
        }
        return 0;
    }

    /**
     * @param a first parameter
     * @param b second parameter
     * @return dividing param a by b and throw new Exception as custom exception
     * @throws Exception
     */
    public double divider(Integer a, Integer b) throws MyCustomException {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new MyCustomException(e.getMessage() + " was catched and thrown as custom Exception");
        }
    }

    public static void main(String[] args) throws Exception {
        MathBox mathBox = new MathBox();

        System.out.println("Method summa: " + mathBox.summa(1, 3));
        System.out.println("\nMethod diff: " + mathBox.diff(1, 3));
        try {
            System.out.println("\nMethod factorial: ");
            System.out.println(mathBox.factorial(Integer.MAX_VALUE));
        } catch (StackOverflowError e) {
            System.out.println("Catched Exception " + e);
        }
        System.out.println("\nMethod dividerExceptionInside: ");
        System.out.println(mathBox.dividerExceptionInside(13, 0));
        System.out.println("\nMethod divider throwing exception: ");
        System.out.println(mathBox.divider(26, 0));

    }

}
