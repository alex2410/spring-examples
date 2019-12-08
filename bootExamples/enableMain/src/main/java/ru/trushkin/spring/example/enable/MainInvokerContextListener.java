package ru.trushkin.spring.example.enable;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.type.MethodMetadata;

import java.lang.reflect.Method;

public class MainInvokerContextListener {

    @Autowired
    private  ConfigurableListableBeanFactory factory;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            String originalClass = beanDefinition.getBeanClassName();
            if(beanDefinition instanceof AnnotatedBeanDefinition) { // definition with @Bean Annotation cause this issue
                MethodMetadata factoryMethodMetadata = ((AnnotatedBeanDefinition) beanDefinition).getFactoryMethodMetadata();
                if (factoryMethodMetadata != null) {
                    originalClass = factoryMethodMetadata.getReturnTypeName();
                }
            }
            try {
                Class<?> aClass = Class.forName(originalClass);
                for (Method method : aClass.getMethods()) {
                    if(method.isAnnotationPresent(Main.class)){
                        Object bean = applicationContext.getBean(beanDefinitionName);
                        Method beanMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        beanMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
