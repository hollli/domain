package com.example.domain;


import com.example.domain.Service;

public class SecondLevelService implements Service {
    private final ThirdLevelService thirdLevelService;

    public SecondLevelService(ThirdLevelService thirdLevelService) {
        this.thirdLevelService = thirdLevelService;
    }

    @Override
    public void performAction() {
        System.out.println("Second Level Service");
        thirdLevelService.performAction();
    }
}
