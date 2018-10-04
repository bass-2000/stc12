package ru.innopolis.stc12.classloaders.lesson.classloaders1;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KindMagicClassLoader extends ClassLoader {
    private static Logger logger = Logger.getLogger(KindMagicClassLoader.class);
    public KindMagicClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("ru.innopolis.stc12.classloaders.lesson.classloaders1.Magic")) {
            Path path = Paths.get("C:/TEMP/", "magic.class");
            byte[] classData = null;
            try (InputStream inputStream = Files.newInputStream(path);
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                int data = inputStream.read();
                while (data != -1) {
                    byteArrayOutputStream.write(data);
                    data = inputStream.read();
                }
                classData = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            int l = classData.length;
            return defineClass(name, classData, 0, l);
        }

        return super.loadClass(name);
    }
}
