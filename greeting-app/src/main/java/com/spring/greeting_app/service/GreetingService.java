package com.spring.greeting_app.service;

import org.springframework.stereotype.Service;

@Service  // Marks this class as a Service component
public class GreetingService {

    // Method to return a simple greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }
}
