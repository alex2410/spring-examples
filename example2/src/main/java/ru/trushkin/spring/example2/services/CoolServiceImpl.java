package ru.trushkin.spring.example2.services;

import javax.annotation.PostConstruct;

public class CoolServiceImpl implements CoolService {

    @Override
    public void say1() {
        System.out.println("postProxy say1");
    }

    @PostConstruct
    @Override
    public void say2() {
        System.out.println("postProxy say2");
    }
}
