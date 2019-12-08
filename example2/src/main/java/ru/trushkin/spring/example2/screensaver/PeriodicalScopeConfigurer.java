package ru.trushkin.spring.example2.screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class PeriodicalScopeConfigurer implements Scope {
    private Map<String, Pair<LocalTime, Object>> cache = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Pair<LocalTime, Object> pair = cache.get(name);
        if (pair != null) {
            int i = LocalTime.now().getSecond() - pair.getV1().getSecond();
            if (i > 5) {
                cache.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            cache.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
        }
        return cache.get(name).getV2();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
