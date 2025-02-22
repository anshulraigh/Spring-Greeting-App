package com.spring.greeting_app.model;

import jakarta.persistence.*;

@Entity  // Marks this class as a JPA entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String message;

    // Default constructor (required by JPA)
    public Greeting() {
    }

    // Constructor to initialize message
    public Greeting(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
