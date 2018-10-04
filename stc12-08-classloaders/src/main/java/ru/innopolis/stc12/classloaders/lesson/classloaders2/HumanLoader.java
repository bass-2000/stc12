package ru.innopolis.stc12.classloaders.lesson.classloaders2;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HumanLoader extends ClassLoader {
    private final String CLAZZNAME = "ru.innopolis.stc12.classloaders2.EuropeanHuman";
    private final String FILEDESTINATION = "file:C://TEMP/EuropeanHuman.class";
    private static Logger logger = Logger.getLogger(HumanLoader.class);
    public HumanLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        if (className.equals(CLAZZNAME)) {
            byte[] byteArrayClassData = fileToByteArray(FILEDESTINATION);
            return defineClass(className, byteArrayClassData, 0, byteArrayClassData.length);
        }

        return super.loadClass(className);
    }

    public static byte[] fileToByteArray(String fileDestination) {
        byte[] fileData = null;

        try (InputStream inputStream = (new URL(fileDestination).openConnection().getInputStream());
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int currentByteOfData = inputStream.read();
            while (currentByteOfData != -1) {
                byteArrayOutputStream.write(currentByteOfData);
                currentByteOfData = inputStream.read();
            }
            fileData = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return fileData;
    }
}
