package ru.trushkin.spring.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.trushkin.spring.example.services.TestService;
import ru.trushkin.spring.example.services.TestServicePrototype;
import ru.trushkin.spring.example.services.TestServiceSession;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ExampleApplication {

    /*
     log.info("StartApplication...");

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));

     */
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    public TestService testService() {
        return new TestService();
    }

    @Bean
    @Qualifier("main")
    public TestService testServiceQualifier() {
        return new TestService();
    }

    @Bean
    @Scope("prototype")
    public TestServicePrototype testServicePrototype() {
        return new TestServicePrototype(new Date());
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
        };
    }
}
