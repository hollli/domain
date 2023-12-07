package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FirstLevelService implements Service {
    private final SecondLevelService secondLevelService;

    @Autowired
    public FirstLevelService(@Qualifier("secondLevelService") Service secondLevelService) {
        this.secondLevelService = (SecondLevelService) secondLevelService;
    }

    @Override
    public void performAction() {
        System.out.println("First Level Service");
        secondLevelService.performAction();
    }
}