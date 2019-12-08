package ru.trushkin.spring.example2.crossreference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trushkin.spring.example2.enable.Main;

import javax.annotation.PostConstruct;

@Component
public class Wife {

    private String text;
    @Autowired
    private Husband husband;

    @PostConstruct
    private void init() {
        System.out.println("Жена: нечего надеть, postConstruct");
        text = "Жена: getSmth";
        // в postConstruct еще не все проинициализировано
        //    System.out.println(husband.getSmth().toUpperCase());

        //сработает, но будет вызван до postConstruct в husband
        // husband.doSmth();
    }

    @Main
    public void action() {
        husband.doSmth();
    }

    public void doSmth() {
        System.out.println("Жена: doSmth");
    }

    public String getSmth() {
        return text;
    }
}
