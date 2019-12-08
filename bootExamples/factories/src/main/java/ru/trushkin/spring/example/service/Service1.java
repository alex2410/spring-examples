package ru.trushkin.spring.example.service;

import org.springframework.stereotype.Service;
import ru.trushkin.spring.example.enable.Main;

@Service
public class Service1 {

    @Main
    public void testMain() {
        System.out.println("test Main");
        System.exit(1);
    }
}
