package ru.innopolis.stc12.generics.part2;


import ru.innopolis.stc12.generics.Exceptions.MyCustomException;

import java.util.Objects;
import java.util.TreeSet;

public class ObjectBox<T> {
    private TreeSet<T> enterSet;

    public ObjectBox(TreeSet<T> enterSet) {
        this.enterSet = enterSet;
    }

    public ObjectBox() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(this.enterSet, objectBox.enterSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enterSet);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toString()+"{" +
                "enterSet=" + this.enterSet +
                '}';
    }

    public void addObject(T obj) {
        this.enterSet.add(obj);
    }

    public void removeObject(T obj) {
        this.enterSet.remove(obj);
    }

    public void dump() {
        System.out.println(this.toString());
    }

    public int summator() throws MyCustomException {
        int result = 0;
        if (this.enterSet.first() instanceof Number) {

            for (T num : this.enterSet) {
              //  result += (int) num;
            }
        } else throw new MyCustomException();
        return result;
    }

    public TreeSet<Integer> splitter(int divider) throws MyCustomException {
        TreeSet<Integer> result = new TreeSet<Integer>();
        if (this.enterSet.first() instanceof Number) {
            for (T num : this.enterSet) {
              //  result.add((int)num / (int) divider);
            }
        } else throw new MyCustomException();
        return result;
    }
}