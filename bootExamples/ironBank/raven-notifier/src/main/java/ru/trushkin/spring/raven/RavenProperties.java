package ru.trushkin.spring.raven;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "raven")
public class RavenProperties {

    private List<String> destionations;

    public List<String> getDestionations() {
        return destionations;
    }

    public void setDestionations(List<String> destionations) {
        this.destionations = destionations;
    }
}
