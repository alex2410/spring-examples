package ru.trushkin.spring.example2.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.trushkin.spring.example2.app.annotations.*;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
@Profilings({
        @Profiling(value = "1"),
        @Profiling(value = "2")
})
@DeprecatedClass(newImpl = T1000.class)
public class QuoterTerminator implements Quoter {

    @InjectRandomInteger(min = 2, max = 7)
    private int count;

    protected String quote;

    private String message;

    public QuoterTerminator() {
        Integer i=0;
        i.toString();
    }
    public QuoterTerminator(@Value("${terminator.quote}") String quote) {
        this.quote = quote;
        //phase 1
        System.out.println("QuoterTerminator constructor count: " + count);
    }

    @Override
    public void sayQuote() {
        IntStream.range(0, count).forEach(value -> System.out.println(value + ": " + quote + ", " + message));
    }

    @PostConstruct
    private void init() {
        //phase 2
        System.out.println("PostConstruct count: " + count);
    }

    @PostProxy
    @Override
    public void postProxy() {
        //phase 3
        System.out.println("Main, all initialized");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
