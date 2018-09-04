package ru.innopolis.stc12.classloaders.lesson.classloaders1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class KindMagicClassLoader extends ClassLoader {
    public KindMagicClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("ru.innopolis.stc12.classloaders.lesson.classloaders1.Magic")) {
            String dest = "file:C://TEMP/magic.class";
            byte[] classData = null;
            try {
                URL url = new URL(dest);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                int data = inputStream.read();
                while (data != -1) {
                    byteArrayOutputStream.write(data);
                    data = inputStream.read();
                }
                inputStream.close();
                classData = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, classData, 0, classData.length);
        }

        return super.loadClass(name);
    }
}
