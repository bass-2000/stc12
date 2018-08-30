package ru.innopolis.stc12.generics.part1;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {15,23,56};
        List<Integer> list1 = Arrays.asList(arr1);
        ObjectBox objectBox1 = new ObjectBox(new TreeSet(list1));
        objectBox1.dump();

        objectBox1.addObject(11);
        objectBox1.dump();

        objectBox1.removeObject(15);
        objectBox1.dump();

        try{
            System.out.println(objectBox1.summator());
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            System.out.println(objectBox1.splitter(2));
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("\nС числами закончили!\n-------------------------------------\n");

        String[] arr2 = {"Alexander","Mikhail", "Valera"};
        List<String> list2 = Arrays.asList(arr2);
        ObjectBox objectBox2 = new ObjectBox(new TreeSet(list2));
        objectBox2.dump();

        objectBox2.addObject("Volodya");
        objectBox2.dump();

        objectBox2.removeObject("Valera");
        objectBox2.dump();


    }
}
