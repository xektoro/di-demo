package com.example.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// we move that 3 annotations in config factory bean method
// @Service
// if there is more than one bean (here we have 5 of type GreetingService), just use this one annotated with @Primary
// so now on every place we want to inject GreetingService, we won't have error, but either PrimaryGreetingServiceImpl
// or PrimarySpanishGreetingServiceImpl or PrimaryGermanGreetingServiceImpl injected (now it will depend only on the active Profile)
// @Primary
// now we have added default, so now if we have not set any active profile or the active profile is "en"
// that will be used, we just say that we want this bean to be selected as default
// @Profile({"en", "default"})
public class PrimaryGreetingServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryGreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
