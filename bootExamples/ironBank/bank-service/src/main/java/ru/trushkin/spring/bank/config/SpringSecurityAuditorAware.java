package ru.trushkin.spring.bank.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class  SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

       return Optional.ofNullable(new Date().toString());
    }
}