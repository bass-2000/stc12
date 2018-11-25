package ru.innopolis.stc12.ioc;

public class FileDownloader implements Downloader {

    @Override
    public String download(String path) {
        System.out.println(new StringBuilder("Resource from path ")
                .append(path)
                .append(" was downloaded")
                .toString());
        return "CoNtEnT";
    }
}
