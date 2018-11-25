package markerInterface;

public class MyClass implements Cloneable {
    private Integer var1;
    private Integer var2;

    public MyClass(Integer var1, Integer var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public Integer getVar1() {
        return var1;
    }

    public void setVar1(Integer var1) {
        this.var1 = var1;
    }

    public Integer getVar2() {
        return var2;
    }

    public void setVar2(Integer var2) {
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "var1=" + var1 +
                ", var2=" + var2 +
                '}';
    }

    protected MyClass clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new MyClass(var1, var2);
    }
}