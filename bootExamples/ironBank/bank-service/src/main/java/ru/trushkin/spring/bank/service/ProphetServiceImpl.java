package ru.trushkin.spring.bank.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.trushkin.spring.bank.ProfileConstants;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Profile(ProfileConstants.WINTER_IS_COMING)
public class ProphetServiceImpl implements ProphetService {

    @Override
    public boolean willSurvive(String name) {
        if ("stark".equalsIgnoreCase(name)) {
            return false;
        }
        return ThreadLocalRandom.current().nextBoolean();
    }
}
