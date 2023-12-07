package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SecondLevelService implements Service {
    private final Service thirdLevelService;

    @Autowired
    public SecondLevelService(Service thirdLevelService) {
        this.thirdLevelService = thirdLevelService;
    }

    @Override
    public void performAction() {
        System.out.println("Second Level Service");
        thirdLevelService.performAction();
    }
}
