package com.writemeabook.restuserapi.controller;

import com.writemeabook.restuserapi.model.User;
import com.writemeabook.restuserapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class WriterController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null)
            throw new NoSuchElementException("There is no user with ID = " + id + " in database");
        return userService.getUser(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted";
    }
}

