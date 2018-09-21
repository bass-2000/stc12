package ru.innopolis.stc12.logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Simple {
    public static void main(String[] args) {
        System.err.println("ATTENCION!");
        try {
            System.setErr(new PrintStream(new FileOutputStream("errLog.log")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("AttaTa");
    }
}
