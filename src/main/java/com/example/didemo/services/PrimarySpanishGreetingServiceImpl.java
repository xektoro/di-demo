package com.example.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// we move that 3 annotations in config factory bean method
// @Service
// now we have two primary annotations for three methods (PrimarySpanishGreetingServiceImpl, PrimaryGermanGreetingServiceImpl, PrimaryGreetingService)
// that implements GreetingService, so now which one will be injected by default will depend on the active profile
// @Primary
// @Profile("es")
public class PrimarySpanishGreetingServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimarySpanishGreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}
