package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
    private final Service topLevelService;

    @Autowired
    public App(@Qualifier("firstLevelService") Service topLevelService) {
        this.topLevelService = topLevelService;
    }

    public void run() {
        topLevelService.performAction();
    }
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = context.getBean(App.class);
            app.run();
        }
    }
}
