package ru.innopolis.stc12.testing.second;

public class SomeClass {
    Helper helper;

    public SomeClass(Helper helper) {
        this.helper = helper;
    }

    public Integer methodWithHelper(Integer a, Integer b) {
        int res = helper.someHelperMethod(a + 10, b + 5);
        return res;
    }

//    public Integer doSomeWork(int a, int b, String c) {
//        Integer tempRes;
//        if (a % 2 == 0) {
//            tempRes = a * b;
//        } else {
//            if (a < 10) {
//                tempRes = a * b + 5;
//            } else {
//                tempRes = a * b + 10;
//            }
//        }
//        return tempRes + Integer.valueOf(c);
//    }
}
