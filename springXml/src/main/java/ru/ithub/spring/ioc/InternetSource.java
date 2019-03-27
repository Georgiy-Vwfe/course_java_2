package ru.ithub.spring.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InternetSource implements Source {
    @Override
    public InputStream getStream() throws IOException {
        URL url = new URL("http://localhost:8080/news.txt");
        return url.openConnection().getInputStream();
    }
}
