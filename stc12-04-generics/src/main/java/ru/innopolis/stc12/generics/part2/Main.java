package ru.innopolis.stc12.generics.part2;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {15,23,56};
        List<Integer> list1 = Arrays.asList(arr1);
        MathBox mathBox1 = new MathBox(list1);
        mathBox1.dump();

        mathBox1.addObject(11);
        mathBox1.dump();

        mathBox1.removeObject(15);
        mathBox1.dump();

        try{
            System.out.println(mathBox1.summator());
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            System.out.println(mathBox1.splitter(2));
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
