package ru.innopolis.stc12.exceptions;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MathBoxTest {
    private static Logger logger = Logger.getLogger(MathBoxTest.class);
    private static MathBox mathBox;

    @BeforeAll
    static void setUp() {
        mathBox = new MathBox();
    }

    @Test
    void summaTest() {
        Assertions.assertEquals(mathBox.summa(2, 3), 5);
    }

    @Test
    void diffTest() {
        Assertions.assertEquals(mathBox.diff(3, 2), 1);
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(mathBox.factorial(1), 1);
        Assertions.assertEquals(mathBox.factorial(0), 1);
        Assertions.assertEquals(mathBox.factorial(3), 6);
    }


    @Test
    void dividerTest() {
        Assertions.assertThrows(MyCustomException.class, () -> mathBox.divider(5, 0));
        double result = 0;
        try {
            result = mathBox.divider(6, 3);
        } catch (MyCustomException e) {
            logger.error(e.getMessage());
        }
        Assertions.assertEquals(2.0, result);
    }

    @Test
    void dividerExceptionInsideTest() {
        double result = mathBox.dividerExceptionInside(10, 5);
        Assertions.assertEquals(2.0, result);
        Assertions.assertDoesNotThrow(() -> mathBox.dividerExceptionInside(5, 0));
    }

    @Test
    void main() {
        String[] args = new String[0];
        Assertions.assertDoesNotThrow(() -> mathBox.main(args));
    }
}