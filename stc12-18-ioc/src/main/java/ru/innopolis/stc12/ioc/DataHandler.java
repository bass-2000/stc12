package ru.innopolis.stc12.ioc;

public class DataHandler {
    private Downloader downloader;
    private Uploader uploader;

    public DataHandler(Downloader downloader, Uploader uploader) {
        this.downloader = downloader;
        this.uploader = uploader;
    }

    public void handleData(String srcPath, String destPath) {
        String content = this.downloader.download(srcPath);
        String handledContent = handle(content);
        this.uploader.upload(destPath, handledContent);
    }

    private String handle(String content) {
        return content.toLowerCase();
    }
}
