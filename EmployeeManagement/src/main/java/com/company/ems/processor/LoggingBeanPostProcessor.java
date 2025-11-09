package com.company.ems.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("Service") || beanName.contains("Repository")) {
            System.out.println("⚙️ Initializing bean: " + beanName);
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("Service") || beanName.contains("Repository")) {
            System.out.println("✅ Bean ready: " + beanName);
        }
        return bean;
    }
}