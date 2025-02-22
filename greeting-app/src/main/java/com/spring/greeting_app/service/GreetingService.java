package com.spring.greeting_app.service;

import com.spring.greeting_app.model.Greeting;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate a greeting message based on user attributes (UC3)
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

    // Save the greeting message (UC4)
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // Find a greeting by ID (UC5)
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // List all greetings (UC6)
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Update a greeting (UC7)
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        });
    }

    // Delete a greeting by ID (UC8)
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
