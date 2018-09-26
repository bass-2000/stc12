package ru.innopolis.stc12.testing.bad;

public class SomeClass {
    public Integer methodWithHelper(Integer a, Integer b) {
        Helper helper = new Helper();
        int res = helper.someHelperMethod(a + 10, b + 15);
        return res;
    }
}
