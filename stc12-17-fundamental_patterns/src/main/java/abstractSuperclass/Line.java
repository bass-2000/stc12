package abstractSuperclass;

public class Line extends Location {
    private int x1, x2;

    public Line(int x, int y, int x1, int x2) {
        setXY(x, y);
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
