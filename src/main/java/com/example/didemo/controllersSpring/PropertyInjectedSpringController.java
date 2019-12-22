package com.example.didemo.controllersSpring;

import com.example.didemo.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedSpringController {

    @Autowired
    // here Spring inject the dependency using reflection at runtime (VERY BAD PRACTICE)
    public GreetingServiceImpl greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
