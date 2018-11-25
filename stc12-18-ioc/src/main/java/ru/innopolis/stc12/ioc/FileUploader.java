package ru.innopolis.stc12.ioc;

public class FileUploader implements Uploader {
    @Override
    public boolean upload(String path, Object content) {
        System.out.println(new StringBuilder("Content ")
                .append(content.toString())
                .append(" was uploaded to path ")
                .append(path));
        return true;
    }
}
