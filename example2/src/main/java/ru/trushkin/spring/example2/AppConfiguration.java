package ru.trushkin.spring.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.trushkin.spring.example2.services.CoolService;
import ru.trushkin.spring.example2.services.CoolServiceImpl;

@Configuration
@ComponentScan(basePackages = {"another", "ru.trushkin.spring.example2"})
@PropertySource(value = "classpath:app.properties", encoding = "UTF-8", ignoreResourceNotFound = true)
public class AppConfiguration {

    @Bean
    public CoolService coolService() {
        return new CoolServiceImpl();
    }

}
