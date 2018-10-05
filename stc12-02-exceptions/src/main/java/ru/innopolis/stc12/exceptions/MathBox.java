package ru.innopolis.stc12.exceptions;


import org.apache.log4j.Logger;

public class MathBox {
    private static Logger logger = Logger.getLogger(MathBox.class);
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

    public static void main(String[] args) throws Exception {
        MathBox mathBox = new MathBox();

        logger.info("Method summa: " + mathBox.summa(1, 3));
        logger.info("\nMethod diff: " + mathBox.diff(1, 3));
        try {
            logger.info("\nMethod factorial: ");
            logger.info(mathBox.factorial(Integer.MAX_VALUE));
        } catch (StackOverflowError e) {
            logger.error("Catched Exception " + e);
        }
        logger.info("\nMethod dividerExceptionInside: ");
        logger.info(mathBox.dividerExceptionInside(13, 0));
        logger.info("\nMethod divider throwing exception: ");
        try {
            logger.info(mathBox.divider(26, 0));
        } catch (MyCustomException e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * @param a first parameter
     * @param b second parameter
     * @return dividing param a by b and throw new Exception as custom exception
     * @throws Exception
     */
    public double divider(Integer a, Integer b) throws MyCustomException {
        try {
            if (b == 0) throw new ArithmeticException();
            return (double) a / b;
        } catch (ArithmeticException e) {
            throw new MyCustomException(e.getMessage() + " was catched and thrown as custom Exception");
        }
    }

    /**
     * @param a first parameter
     * @param b second parameter
     * @return dividing param a by b with catching Arithmetic Exception
     */
    public double dividerExceptionInside(Integer a, Integer b) {
        try {
            if (b == 0) throw new ArithmeticException();
            return (double) a / b;
        } catch (ArithmeticException e) {
            logger.info("Catched Exception " + e);
        }
        return 0;
    }

}
