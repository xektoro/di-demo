package com.example.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Injected by constructor";
    }
}
