package ru.innopolis.stc12.springSp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");
        while (true) {
            context.getBean(Some.class).doSome();
        }
    }
}