package ru.innopolis.stc12.testing.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//НАДО ПОЧИНИТЬ!111
public class SomeClassTest {
    private SomeClass someClass;
    private Helper helper = Mockito.mock(Helper.class);

    @BeforeEach
    void before() {
        someClass = new SomeClass(helper);
    }

    @Test
    void methodWithHelperTest() {
        when(helper.someHelperMethod(anyInt(), anyInt())).thenReturn(1);
        Integer res = someClass.methodWithHelper(1, 2);
        verify(helper).someHelperMethod(11, 7);
        Assertions.assertEquals(new Integer(1), res);
    }
}
