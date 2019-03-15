package ru.ithub.spring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public NewsReader newsReader() {
        return new NewsReader();
    }

    @Bean
    public Source source() {
        return new FileSource();
    }
}
