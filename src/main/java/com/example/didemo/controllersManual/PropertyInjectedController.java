package com.example.didemo.controllersManual;

import com.example.didemo.services.GreetingServiceImpl;

// very bad example
public class PropertyInjectedController {
    public GreetingServiceImpl greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
