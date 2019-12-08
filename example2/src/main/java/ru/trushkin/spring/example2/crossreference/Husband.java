package ru.trushkin.spring.example2.crossreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trushkin.spring.example2.enable.Main;

import javax.annotation.PostConstruct;

@Component
public class Husband {

    private String text;
    @Autowired
    private Wife wife;

    @PostConstruct
    private void init() {
        System.out.println("Муж: футбол, postConstruct");
        text = "Муж: getSmth";
        // в postConstruct еще не все проинициализировано
        //System.out.println(wife.getSmth().toUpperCase());

        //сработает, но будет вызван до postConstruct в wife
       // wife.doSmth();
    }

    @Main
    public void action(){
        wife.doSmth();
    }

    public void doSmth() {
        System.out.println("Муж: doSmth");
    }

    public String getSmth() {
        return text;
    }
}
