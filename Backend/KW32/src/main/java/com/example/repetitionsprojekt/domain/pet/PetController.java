package com.example.repetitionsprojekt.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}