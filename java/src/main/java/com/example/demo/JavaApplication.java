package com.example.javaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class JavaApplication {

    @Value("${server.port}")
    private String port;

    @PostConstruct
    public void startupMessage() {
        System.out.println("==================================");
        System.out.println("Java Service started successfully");
        System.out.println("Server running on port: " + port);
        System.out.println("==================================");
    }

    @GetMapping("/")
    public String home() {
        return "Java service running";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + " from Java";
    }

    @PostMapping("/add")
    public int add(@RequestBody Numbers numbers) {
        return numbers.a + numbers.b;
    }

    static class Numbers {
        public int a;
        public int b;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }
}