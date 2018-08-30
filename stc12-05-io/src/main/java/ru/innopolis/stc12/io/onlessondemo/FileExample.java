package ru.innopolis.stc12.io.onlessondemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("D:\\SomeDir\\note.txt");
        FileOutputStream fos = new FileOutputStream("D:\\SomeDir\\new.txt")){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer,0,buffer.length);
            fos.write(buffer,0,buffer.length);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
