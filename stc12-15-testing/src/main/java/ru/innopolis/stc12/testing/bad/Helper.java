package ru.innopolis.stc12.testing.bad;


public class Helper implements ru.innopolis.stc12.testing.second.Helper {
    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return (a + b) * 2;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        System.out.println((a + b) * 2);
    }
}
