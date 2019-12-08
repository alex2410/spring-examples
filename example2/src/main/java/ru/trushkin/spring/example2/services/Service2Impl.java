package ru.trushkin.spring.example2.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class Service2Impl implements Service2 {
    @Override
    public String text() {
        return "text from Impl";
    }
}
