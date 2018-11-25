package abstractSuperclass;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(1, 1, 4, 4);
        line.setXY(5, 5);
        System.out.println(line);
        line.moveleft(3);
        System.out.println(line);
    }
}