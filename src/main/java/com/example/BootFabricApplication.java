package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BootFabricApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootFabricApplication.class, args);
    }
}

@RestController
class GreetingController {

    @Value("${message.name}")
    private String name;

    @Value("${username}")
    private String username;

    @Autowired
    private GreetingConfiguration configuration;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, " + configuration.getName() + "! , Your secret username is : " + username;
    }
}
