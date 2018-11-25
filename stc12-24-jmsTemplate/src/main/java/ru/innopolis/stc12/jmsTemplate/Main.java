package ru.innopolis.stc12.jmsTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        String queue = "stc12.out";

        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.send(queue, "Hello,world");
        messageSender.send(queue, "Hello,world 2");
        messageSender.send(queue, "Hello,world 3");

        System.out.println("Stopping listener");
        DefaultMessageListenerContainer container = context.getBean(DefaultMessageListenerContainer.class);
        container.shutdown();

        container.initialize();
        container.start();
        messageSender.send(queue, "Hello,world 4");
        messageSender.send(queue, "Hello,world 5");
        messageSender.send(queue, "Hello,world 6");
    }
}