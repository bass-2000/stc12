package ru.innopolis.stc12.io.onlessondemo;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;

public class ByteArrayExample {
    private static Logger logger = Logger.getLogger(ByteArrayExample.class);
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1,5,5,7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
        int b;
        while((b = byteArrayInputStream.read())!=-1){
            logger.info(b);
        }

        String text = "My string";

    }
}
