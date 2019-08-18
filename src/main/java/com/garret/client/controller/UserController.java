package com.garret.client.controller;

import com.garret.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private RestTemplate restTemplate;
    private static final String SERVER_URL = "http://localhost:8080/hashPassword";

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hash")
    public User allUsers() {
        User user = new User(35L, "test", "test");
        return restTemplate.postForObject(SERVER_URL, user, User.class);
    }
}
