package com.company.ems.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.company.ems")
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-${spring.profiles.active:dev}.properties")
@EnableScheduling
public class AppConfig {
}