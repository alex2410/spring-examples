package ru.trushkin.spring.raven;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class RavenConfiguration {

    @Bean
    @ConditionalOnProduction
    @ConditionalOnProperty("raven.destionations")
    @ConditionalOnMissingBean(ApplicationListener.class)
    public RavenNotifier ravenNotifier(RavenProperties ravenProperties) {
        return new RavenNotifier(ravenProperties);
    }

}
