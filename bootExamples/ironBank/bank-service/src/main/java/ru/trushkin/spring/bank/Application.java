package ru.trushkin.spring.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ru.trushkin.spring.bank.config.SpringSecurityAuditorAware;
import ru.trushkin.spring.bank.service.ProphetProperties;

@SpringBootApplication

@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@EnableConfigurationProperties(ProphetProperties.class)
public class Application {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }

    @Bean
    public ApplicationListener<ContextRefreshedEvent> applicationListener() {
        return event -> {
            System.out.println();
            System.out.println(event);
            System.out.println();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
