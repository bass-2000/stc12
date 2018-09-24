package ru.innopolis.stc12.testing.second;

public class HelperImpl implements Helper {
    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return (a + b) * 2;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        System.out.println((a + b) * 2);
    }
}
