package ru.trushkin.spring.example2.screensaver;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "ru.trushkin.spring.example2.screensaver")
public class ScreenSaverConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Color color() {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    @Bean
    @Scope("periodical")
    public Color colorPeriodical() {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    @Bean
    public ColorFrame colorFramePeriodical() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return colorPeriodical();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
        while (true) {
            context.getBean("colorFramePeriodical", ColorFrame.class).showOnRandomPlace();
            Thread.sleep(300);
        }
    }
}
