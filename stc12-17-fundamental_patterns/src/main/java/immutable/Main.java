package immutable;

public class Main {
    public static void main(String[] args) {
        SomePojo somePojo = new SomePojo("anotherString", 5);
        SomeClass someClass = new SomeClass("string", 12, somePojo);
        System.out.println(someClass);
        SomePojo newPojo = someClass.getSomePojo();
        newPojo.setIntValue(15);
        newPojo.setStrValue("Changed value");
        System.out.println(someClass);
    }
}
