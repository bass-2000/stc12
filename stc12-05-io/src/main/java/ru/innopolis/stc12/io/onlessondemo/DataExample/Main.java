package ru.innopolis.stc12.io.onlessondemo.DataExample;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person psn = new Person("Tom", 35, 1.9, true);
        writePerson(psn);
        System.out.println(readPerson());
    }

    public static void writePerson(Person person){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"))) {
            dataOutputStream.writeUTF(person.getName());
            dataOutputStream.writeInt(person.getAge());
            dataOutputStream.writeDouble(person.getHeight());
            dataOutputStream.writeBoolean(person.isMarried());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Person readPerson(){
        Person person = new Person();
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.bin"))){
            person.setName(dataInputStream.readUTF());
            person.setAge(dataInputStream.readInt());
            person.setHeight(dataInputStream.readDouble());
            person.setMarried(dataInputStream.readBoolean());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return person;
    }

}

