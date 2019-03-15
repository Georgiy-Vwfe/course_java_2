package ru.ithub.spring.ioc;

public class News {
    private String content = "";
    private String title;

    public News(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addLine(String text) {
        if(text != null)
            this.content += text + "\n";
    }

    @Override
    public String toString() {
        return "News{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
