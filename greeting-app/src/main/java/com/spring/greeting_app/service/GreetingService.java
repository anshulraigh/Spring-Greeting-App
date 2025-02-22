package com.spring.greeting_app.service;

import org.springframework.stereotype.Service;

@Service  // Marks this class as a Service component
public class GreetingService {

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
}
