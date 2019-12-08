package ru.trushkin.spring.example2.app.annotations;

import ru.trushkin.spring.example2.app.Quoter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class<? extends Quoter> newImpl();
}
