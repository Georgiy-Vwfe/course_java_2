package ru.ithub.spring.ioc;

import java.io.IOException;
import java.io.InputStream;

public interface Source {

    InputStream getStream() throws IOException;
}
