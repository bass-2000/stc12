package ru.innopolis.stc12.proxy.lesson.first_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainingCenter implements InvocationHandler {
    private Trainer trainer;

    public TrainingCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I take your money");
        System.out.println("I give to trainer and coneultants");
        System.out.println("Let's go study");

        if(method.getName().equals("talk")){
            System.out.println("Who's late?");
        }
        return method.invoke(trainer,args);
    }
}
