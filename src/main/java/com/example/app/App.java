package com.example.app;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/api/hello")
    public String hello() {
        return "Backend API is working!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
