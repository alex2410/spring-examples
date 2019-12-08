package ru.trushkin.spring.raven;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public class RavenNotifier {

    private RavenProperties ravenProperties;

    public RavenNotifier(RavenProperties ravenProperties) {
        this.ravenProperties = ravenProperties;
    }

    @EventListener
    public void sendRaven(ContextRefreshedEvent contextRefreshedEvent) {
        ravenProperties.getDestionations().forEach(s -> {
            System.out.println();
            System.out.println("Raven sent to " + s);
            System.out.println();
        });
    }
}
