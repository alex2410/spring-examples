package ru.trushkin.spring.example2.app.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(value = Profilings.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
    String value() default "0";
}
