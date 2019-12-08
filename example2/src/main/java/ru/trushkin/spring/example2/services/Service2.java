package ru.trushkin.spring.example2.services;

public interface Service2 {

    String text();

    default String text2() {
        return getText();
    }

    private static String getText() {
        return "defaultStatic";
    }
}
