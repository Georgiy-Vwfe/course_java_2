package ru.ithub.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {

    public static void main(String[] args) {
        FileSource source = new FileSource();
        NewsReader reader = new NewsReader();
        reader.setSource(source);
    }
}
