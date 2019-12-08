package ru.trushkin.spring.example2.app.annotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import ru.trushkin.spring.example2.app.mbean.ProfilingController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProfilingBeanAnnotationPostProcessor implements BeanPostProcessor {
    private Map<String, Class> beans = new HashMap<>();
    private ProfilingController profilingController = new ProfilingController();

    public ProfilingBeanAnnotationPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(profilingController,
                new ObjectName("profiling", "name", "enableController"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        if (aClass.getAnnotationsByType(Profiling.class).length > 0) {
            beans.put(beanName, aClass);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = beans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), getHandler(bean));
        }
        return bean;
    }

    private InvocationHandler getHandler(Object bean) {
        return (proxy, method, args) -> {
            if (!profilingController.isEnabled()) {
                System.out.println("Profiling method: " + method.getName());
                long before = System.nanoTime();
                Object result = ReflectionUtils.invokeMethod(method, bean, args);
                long after = System.nanoTime();
                System.out.println("Time: " + (after - before));
                return result;
            } else {
                return ReflectionUtils.invokeMethod(method, bean, args);
            }
        };
    }
}
