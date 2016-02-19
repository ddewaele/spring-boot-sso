package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @RequestMapping("/user")
    public Principal getPrincipal(Principal user) {
        return user;
    }

}
