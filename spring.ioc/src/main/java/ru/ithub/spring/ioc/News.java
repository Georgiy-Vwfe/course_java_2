package ru.ithub.spring.ioc;

public class News {
    private String content;
    private String title;


    public String getContent() {
        return content;
    }

    //classLoadingMXBean
    //managmentFactory
    public void setContent(String content) {
        this.content = content;
    }
}
