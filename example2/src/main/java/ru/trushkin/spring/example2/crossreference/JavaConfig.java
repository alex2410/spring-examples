package ru.trushkin.spring.example2.crossreference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.trushkin.spring.example2.enable.EnableMain;

@ComponentScan
@Configuration
@EnableMain
public class JavaConfig {

    public Husband husband() {
        return new Husband();
    }

    public Wife wife() {
        return new Wife();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
