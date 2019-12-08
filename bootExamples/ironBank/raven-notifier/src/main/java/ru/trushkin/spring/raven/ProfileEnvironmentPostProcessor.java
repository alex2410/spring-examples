package ru.trushkin.spring.raven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.ThreadLocalRandom;

public class ProfileEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            environment.addActiveProfile("winterIsHere");
            System.out.println("winterIsHere");
        } else {
            environment.addActiveProfile("winterIsComing");
            System.out.println("winterIsComing");
        }
    }
}
