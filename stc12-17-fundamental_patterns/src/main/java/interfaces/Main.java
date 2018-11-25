package interfaces;

public class Main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        someClass.someMethod1();
        ((FirstInterface) someClass).someMethod1();
        ((SecondInterface) someClass).someMethod1();
    }
}
