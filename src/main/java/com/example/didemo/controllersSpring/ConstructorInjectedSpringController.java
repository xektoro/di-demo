package com.example.didemo.controllersSpring;

import com.example.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedSpringController {

    private GreetingService greetingService;

    // it will work with and without "@Autowired"
    // @Autowired
    public ConstructorInjectedSpringController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
