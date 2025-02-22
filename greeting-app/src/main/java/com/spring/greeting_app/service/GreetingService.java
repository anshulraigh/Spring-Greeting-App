package com.spring.greeting_app.service;

import com.spring.greeting_app.model.Greeting;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service  // Marks this class as a Service component
public class GreetingService {

    private final GreetingRepository greetingRepository;

    // Constructor Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate a greeting message based on user attributes
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }

    // Save the greeting message to the database (UC4)
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
}
