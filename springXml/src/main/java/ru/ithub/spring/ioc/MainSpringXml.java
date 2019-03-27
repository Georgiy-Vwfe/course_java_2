package ru.ithub.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainSpringXml {
    private NewsReader newsReader;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Source fileSource = (FileSource) context.getBean("fileSource");
        System.out.println("Dependent bean name for using " + fileSource.toString());
        NewsReader newsReader = (NewsReader) context.getBean("newsReader");
        System.out.println("Dependent bean name for other " + newsReader.toString());
        ((ClassPathXmlApplicationContext) context).close();
    }

    public void afterPropertiesSet() throws Exception {
        try {
            newsReader
                    .list()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
