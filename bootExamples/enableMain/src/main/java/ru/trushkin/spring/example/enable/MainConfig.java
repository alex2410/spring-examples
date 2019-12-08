package ru.trushkin.spring.example.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public MainInvokerContextListener mainInvokerContextListener() {
        return new MainInvokerContextListener();
    }
}
