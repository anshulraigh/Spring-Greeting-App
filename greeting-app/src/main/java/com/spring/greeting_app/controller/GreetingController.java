package com.spring.greeting_app.controller;

import com.spring.greeting_app.model.Greeting;
import com.spring.greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Method to create a standardized JSON response
    private ResponseEntity<Map<String, Object>> createResponse(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    // UC3: GET Request - Personalized Greeting
    @GetMapping("/personalized")
    public ResponseEntity<Map<String, Object>> getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return createResponse("Greeting message generated", greetingService.getPersonalizedGreeting(firstName, lastName));
    }

    // UC2: GET Request - Default Greeting
    @GetMapping
    public ResponseEntity<Map<String, Object>> getGreeting() {
        return createResponse("Default Greeting", greetingService.getPersonalizedGreeting(null, null));
    }

    // UC1: POST Request - Greeting
    @PostMapping
    public ResponseEntity<Map<String, Object>> postGreeting() {
        return createResponse("Greeting received via POST request!", null);
    }

    // UC1: PUT Request - Update Greeting
    @PutMapping
    public ResponseEntity<Map<String, Object>> putGreeting() {
        return createResponse("Greeting updated via PUT request!", null);
    }

    // UC1: DELETE Request - Delete Greeting
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteGreeting() {
        return createResponse("Greeting deleted via DELETE request!", null);
    }

    // UC4: POST Request - Save Greeting Message
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveGreeting(@RequestParam String message) {
        Greeting savedGreeting = greetingService.saveGreeting(message);
        return createResponse("Greeting saved successfully!", savedGreeting);
    }

    // UC5: GET Request - Find Greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        return greeting.map(g -> createResponse("Greeting found!", g))
                .orElseGet(() -> createResponse("Greeting not found!", null));
    }

    // UC6: GET Request - List All Greeting Messages
    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        return ResponseEntity.ok(greetingService.getAllGreetings());
    }

    // UC7: PUT Request - Edit a Greeting Message
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String newMessage = requestBody.get("message");
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, newMessage);
        return updatedGreeting.map(g -> createResponse("Greeting updated successfully!", g))
                .orElseGet(() -> createResponse("Greeting not found!", null));
    }
}
