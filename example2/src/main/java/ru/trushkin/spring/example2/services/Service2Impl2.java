package ru.trushkin.spring.example2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("impl2")
@Service
public class Service2Impl2 implements Service2 {
    @Override
    public String text() {
        return "text from Impl 2";
    }
}
