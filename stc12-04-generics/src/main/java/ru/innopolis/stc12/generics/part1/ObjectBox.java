package ru.innopolis.stc12.generics.part1;


import org.apache.log4j.Logger;
import ru.innopolis.stc12.generics.Exceptions.MyCustomException;

import java.util.*;


public class ObjectBox<T> {
    private static Logger logger = Logger.getLogger(ObjectBox.class);
    private Set<T> enterSet = new TreeSet<T>();

    public ObjectBox(Set<T> enterSet) {
        this.enterSet = enterSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(enterSet, objectBox.enterSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterSet);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "enterSet=" + enterSet +
                '}';
    }

    public void addObject(T obj) {
        this.enterSet.add(obj);
    }

    public void removeObject(T obj) {
        this.enterSet.remove(obj);
    }

    public void dump() {
        logger.error(this.toString());
    }

    public int summator() throws MyCustomException {
        int result = 0;
        if (enterSet.iterator().next() instanceof Number) {

            for (T num : enterSet) {
                result += Integer.parseInt(num.toString()) ;
            }
        } else throw new MyCustomException();
        return result;
    }

    public List<Integer> splitter(int divider) throws MyCustomException {
        List<Integer> result = new ArrayList<Integer>();
        if (enterSet.iterator().next() instanceof Number) {
            for (T num : enterSet) {
                result.add(((Number) num).intValue() / (int) divider);
            }
        } else throw new MyCustomException();
        return result;
    }
}
