package com.example.didemo.controllersSpring;

import com.example.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        //System.out.println("Heloooo!");

        //return "foo";
        return greetingService.sayGreeting();
    }
}
