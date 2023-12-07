package com.example.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
    private final Service firstLevelService;
    private final Service secondLevelService;

    public App(@Qualifier("firstLevelService") Service firstLevelService,
               @Qualifier("secondLevelService") Service secondLevelService) {
        this.firstLevelService = firstLevelService;
        this.secondLevelService = secondLevelService;
    }

    public void run() {
        firstLevelService.performAction();
        secondLevelService.performAction();
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = context.getBean(App.class);
            app.run();
        }
    }
}
