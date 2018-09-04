package ru.innopolis.stc12.classloaders.lesson.classloaders1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        ClassLoader parentClassLoader = Magic.class.getClassLoader();
        Class magicClass = parentClassLoader.loadClass("ru.innopolis.stc12.classloaders1.Magic");
        Magic magic = (Magic) magicClass.newInstance();
        magic.cast();

        KindMagicClassLoader kindMagicClassLoader = new KindMagicClassLoader(parentClassLoader);
        Class kindMagicClass = kindMagicClassLoader.loadClass("ru.innopolis.stc12.classloaders1.Magic");
        /*Magic magic1 = (Magic) kindMagicClass.newInstance();
        magic1.cast();*/

        kindMagicClass.getMethod("cast").invoke(kindMagicClass.newInstance(), null);

    }
}
