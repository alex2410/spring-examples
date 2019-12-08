package ru.trushkin.spring.example2.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MainConfig.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableMain {
}
