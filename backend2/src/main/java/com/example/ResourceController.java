package com.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @RequestMapping("/sayHello")
    public Greeting sayHello() {
        return new Greeting("Spring Boot Backend2");
    }

    @RequestMapping("/public")
    public String publicRequest() {
        return "public_response from Backend2";
    }

    @RequestMapping("/user")
    public Principal getPrincipal(Principal user) {
        return user;
    }

}
