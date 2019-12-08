package ru.trushkin.spring.example2.app.annotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Service
public class InjectRandomIntegerAnnotationPostProcessor implements BeanPostProcessor, InitializingBean {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before: " + beanName + ", class: " + bean.getClass());
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            InjectRandomInteger annotation = declaredField.getAnnotation(InjectRandomInteger.class);
            if (annotation != null) {
                int max = annotation.max();
                int min = annotation.min();
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, new Random().nextInt(max - min) + min);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after: " + beanName + ", class: " + bean.getClass());
        return bean;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean here");
    }
}
