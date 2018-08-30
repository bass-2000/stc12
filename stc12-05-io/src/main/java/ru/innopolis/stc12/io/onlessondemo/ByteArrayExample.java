package ru.innopolis.stc12.io.onlessondemo;

import java.io.ByteArrayInputStream;

public class ByteArrayExample {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1,5,5,7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
        int b;
        while((b = byteArrayInputStream.read())!=-1){
            System.out.println(b);
        }

        String text = "My string";

    }
}
