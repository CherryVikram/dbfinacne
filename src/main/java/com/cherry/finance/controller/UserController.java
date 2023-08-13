package com.cherry.finance.controller;

import com.cherry.finance.model.User;
import com.cherry.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Server up and running", HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/enabled")
    public List<User> getAllEnabledUsers() {
        return userService.getAllEnabledUsers();
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable UUID userId) {
        return userService.getUserByUserId(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
