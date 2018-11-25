package ru.innopolis.stc12.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        DataHandler dataHandler = (DataHandler) context.getBean("dataHandler");

        dataHandler.handleData("someUrl", "SomeOtherUrl");
    }
}
