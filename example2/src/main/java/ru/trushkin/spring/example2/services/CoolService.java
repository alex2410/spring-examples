package ru.trushkin.spring.example2.services;

import ru.trushkin.spring.example2.app.annotations.PostProxy;

public interface CoolService {

    @PostProxy
    void say1();

    void say2();
}
