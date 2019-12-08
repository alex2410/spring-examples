package ru.trushkin.spring.example.services;

import java.util.Date;

public class TestServicePrototype {

    private Date date;

    public TestServicePrototype(Date date) {

        this.date = date;
    }

    public String sayTest() {
        return date + "prototype";
    }
}
