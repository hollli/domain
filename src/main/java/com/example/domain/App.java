package com.example.domain;

import com.example.domain.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            // Get the top-level bean
            Service topLevelService = context.getBean("firstLevelService", Service.class);

            // Perform the action
            topLevelService.performAction();
        }
    }
}
