package ru.innopolis.stc12.classloaders.lesson.classloaders2;

public class EuropeanHuman implements Human {

    @Override
    public void eat(String what, int howMany) {
        System.out.println("Omnomnom " + what + " count " + howMany);
    }

    @Override
    public void sleep(int duration) {
        System.out.println("HHRRRRRR " + duration + " hours");
    }

    @Override
    public String saySmth() {
        return "I'm not from London";
    }
}
