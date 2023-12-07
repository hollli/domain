package com.example.domain;

import com.example.domain.Service;

public class FirstLevelService implements Service {
    private final SecondLevelService secondLevelService;

    public FirstLevelService(SecondLevelService secondLevelService) {
        this.secondLevelService = secondLevelService;
    }

    @Override
    public void performAction() {
        System.out.println("First Level Service");
        secondLevelService.performAction();
    }
}
