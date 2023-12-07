package com.example.domain;

import org.springframework.beans.factory.annotation.Value;

public class ThirdLevelService implements Service {
    private final String message;

    // Конструктор за замовчуванням для Spring DI
    public ThirdLevelService() {
        this.message = null; // або встановіть значення за замовчуванням, якщо потрібно
    }

    // Конструктор для введення значення message
    public ThirdLevelService(String message) {
        this.message = message;
    }



    @Override
    public void performAction() {
        System.out.println("Third Level Service: " + message);
    }
}
