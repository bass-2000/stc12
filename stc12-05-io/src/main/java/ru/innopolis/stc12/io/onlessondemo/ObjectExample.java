package ru.innopolis.stc12.io.onlessondemo;

import ru.innopolis.stc12.io.onlessondemo.DataExample.Person;

import java.io.*;
import java.util.ArrayList;

public class ObjectExample {
    public static void main(String[] args) {
        String filename = "people.dat";

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Tom",35,1.5, true));
        persons.add(new Person("Alex",22,1.6, false));
        persons.add(new Person("Fill",25,1.9, true));
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream.writeObject(persons);
            System.out.println("Запись произведена");
        }catch (IOException ex){
            System.out.println(ex);
    }
    ArrayList<Person> newPersons = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            newPersons = (ArrayList<Person>)objectInputStream.readObject();
        }catch (Exception e){
            System.out.println(e);
        }
        for(Person p : newPersons){
            System.out.println(p);
        }
}}
