package com.example.didemo.controllersManual;

import com.example.didemo.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// this is how we can test Property Injection - never to inject things like that
public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    // very verbose
    @BeforeEach
    public void setUp() {
        // if we comment one row we will have unsatisfied dependency, because the injections
        // are happening on multiple rows and some of them did not happen and I get NPE
        // (the same as we forget to annotate a class in Spring)
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, propertyInjectedController.sayHello());
    }
}
