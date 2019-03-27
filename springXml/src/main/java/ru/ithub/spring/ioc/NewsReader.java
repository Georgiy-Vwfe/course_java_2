package ru.ithub.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsReader {

    private Source source;

    @Autowired
    public void setSource(Source source) {
        this.source = source;
    }

    List<News> list() throws IOException {
        Optional<InputStream> source = Optional.ofNullable(this.source.getStream());

        List<News> news = new ArrayList<>();

        LineNumberReader reader = new LineNumberReader(
                new InputStreamReader(source.orElseThrow(() -> new RuntimeException("No such resources"))));

        String string = reader.readLine();

        News oneNews = null;
        while (string != null) {
            if(string.isEmpty()) {
                if(oneNews != null) {
                    news.add(oneNews);
                    oneNews = null;
                }
            } else if(oneNews == null) {
                oneNews = new News(string);
            } else {
                oneNews.addLine(string);
            }
            string = reader.readLine();
        }

        if(oneNews != null)
            news.add(oneNews);

        String str = oneNews != null ? "not null" : "null";
        if(oneNews != null) {
            str = "not null";
        } else {
            str = "null";
        }

        return news;
    }
}
