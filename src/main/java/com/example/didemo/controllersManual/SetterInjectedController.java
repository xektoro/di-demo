package com.example.didemo.controllersManual;

import com.example.didemo.services.GreetingService;

public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    // any class implementing that interface can be injected here
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
