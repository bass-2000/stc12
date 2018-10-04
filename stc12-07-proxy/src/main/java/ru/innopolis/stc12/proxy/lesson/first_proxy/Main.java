package ru.innopolis.stc12.proxy.lesson.first_proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.Proxy;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        Trainer trainer = new JavaTrainer();
        TrainingCenter trainingCenter = new TrainingCenter(trainer);
        Trainer stc = (Trainer) Proxy.newProxyInstance(TrainingCenter.class.getClassLoader(),new Class[]{Trainer.class}, trainingCenter);
        logger.info("Without proxy");
        trainer.eat();
        trainer.talk();
        trainer.teach();
        logger.info("\nWith proxy");

        stc.teach();
        stc.talk();
        stc.eat();
    }
}
