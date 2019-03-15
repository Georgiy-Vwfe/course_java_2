package ru.ithub.spring.ioc;

import java.io.InputStream;
import java.net.URLConnection;

public class InternetSource implements Source {
    @Override
    public InputStream getStream() {
        return URLConnection;
    }
}
