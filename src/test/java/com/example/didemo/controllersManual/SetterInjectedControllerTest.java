package com.example.didemo.controllersManual;

import com.example.didemo.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetterInjectedControllerTest {
    private SetterInjectedController setterInjectedController;

    // verbose
    @BeforeEach
    public void setUp() {
        // if we comment one row we will have unsatisfied dependency, because the injections
        // are happening on multiple rows and some of them did not happen and I get NPE
        // (the same as we forget to annotate a class in Spring)
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, setterInjectedController.sayHello());
    }
}
