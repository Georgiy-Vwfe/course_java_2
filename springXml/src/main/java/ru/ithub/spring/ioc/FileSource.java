package ru.ithub.spring.ioc;

import java.io.InputStream;

public class FileSource implements Source {

    public InputStream getStream() {
        return ClassLoader.getSystemResourceAsStream("news.txt");
    }
}
