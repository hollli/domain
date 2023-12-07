package com.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ThirdLevelService implements Service {
    private String message;

    @Value("${third.level.message}")
    private String defaultMessage;

    @PostConstruct
    public void init() {
        this.message = defaultMessage;
    }

    @Override
    public void performAction() {
        System.out.println("Third Level Service: " + message);
    }
}