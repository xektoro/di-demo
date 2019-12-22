package com.example.didemo.controllersSpring;

import com.example.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedSpringController {

    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    @Autowired
    // @Qualifier("setterGreetingServiceImpl") // Qualifiers on setter can be declared either on method level or with the parameters
    public void setGreetingService(@Qualifier("setterGreetingServiceImpl")GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
