package ru.trushkin.spring.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.trushkin.spring.bank.ProfileConstants;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Profile(ProfileConstants.WINTER_IS_HERE)
public class WhiteListProphetServiceImpl implements ProphetService {

    @Autowired
    private ProphetProperties prophetProperties;

    @Override
    public boolean willSurvive(String name) {
        return prophetProperties.getWhiteList().contains(name);
    }
}
