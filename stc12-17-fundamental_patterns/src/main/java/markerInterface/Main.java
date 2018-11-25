package markerInterface;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(14, 15);
        MyClass myClass2 = myClass.clone();
        System.out.println(myClass2);
    }
}
