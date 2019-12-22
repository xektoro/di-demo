package com.example.didemo.controllersManual;

import com.example.didemo.services.GreetingService;

public class ConstructorInjectedController {

    private GreetingService greetingService;

    // any class implementing that interface can be injected here
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
