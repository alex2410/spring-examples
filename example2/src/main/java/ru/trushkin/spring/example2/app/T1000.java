package ru.trushkin.spring.example2.app;

import org.springframework.beans.factory.annotation.Value;

public class T1000 extends QuoterTerminator {

    public T1000(@Value("${t1000.quote}") String quote) {
        super(quote);
    }

    @Override
    public void sayQuote() {
        System.out.println(quote);
    }
}
