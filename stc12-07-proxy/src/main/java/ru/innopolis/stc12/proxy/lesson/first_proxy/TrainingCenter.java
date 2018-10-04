package ru.innopolis.stc12.proxy.lesson.first_proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainingCenter implements InvocationHandler {
    private Trainer trainer;
    private static Logger logger = Logger.getLogger(TrainingCenter.class);
    public TrainingCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("I take your money");
        logger.info("I give to trainer and coneultants");
        logger.info("Let's go study");

        if(method.getName().equals("talk")){
            logger.info("Who's late?");
        }
        return method.invoke(trainer,args);
    }
}
