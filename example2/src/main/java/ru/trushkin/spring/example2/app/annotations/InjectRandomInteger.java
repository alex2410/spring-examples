package ru.trushkin.spring.example2.app.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInteger {
    int min() default 1;

    int max() default 1;
}
