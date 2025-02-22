package com.spring.greeting_app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // Method to create a JSON response
    private ResponseEntity<Map<String, String>> createResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    // UC1: GET Request - Default Greeting
    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        return createResponse("Hello, Welcome to the Greeting App!");
    }

    // UC1: POST Request - Greeting
    @PostMapping
    public ResponseEntity<Map<String, String>> postGreeting() {
        return createResponse("Greeting received via POST request!");
    }

    // UC1: PUT Request - Update Greeting
    @PutMapping
    public ResponseEntity<Map<String, String>> putGreeting() {
        return createResponse("Greeting updated via PUT request!");
    }

    // UC1: DELETE Request - Delete Greeting
    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteGreeting() {
        return createResponse("Greeting deleted via DELETE request!");
    }
}
