package ru.ithub.spring.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public interface Source {

    InputStream getStream() throws IOException;
}
