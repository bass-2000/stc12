package ru.innopolis.stc12.io.onlessondemo;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.io.onlessondemo.dataexample.Person;

import java.io.*;
import java.util.ArrayList;

public class ObjectExample {
    private static Logger logger = Logger.getLogger(ObjectExample.class);
    public static void main(String[] args) {
        String filename = "people.dat";

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Tom",35,1.5, true));
        persons.add(new Person("Alex",22,1.6, false));
        persons.add(new Person("Fill",25,1.9, true));
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream.writeObject(persons);
            logger.info("Запись произведена");
        }catch (IOException ex){
            logger.error(ex.getMessage());
    }
    ArrayList<Person> newPersons = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            newPersons = (ArrayList<Person>)objectInputStream.readObject();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        for(Person p : newPersons){
            logger.info(p);
        }
}}
