package ru.innopolis.stc12.testing.second;

public class SomeClass {
    Helper helper;

    public SomeClass(Helper helper) {
        this.helper = helper;
    }

    public Integer methodWithHelper(Integer a, Integer b) {
        return helper.someHelperMethod(a + 10, b + 5);
    }
}


