package com.codewitharjun.app.controller;


import com.codewitharjun.app.exception.UserNotFoundException;
import com.codewitharjun.app.model.User;
import com.codewitharjun.app.service.UserService;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        if(!userService.existsById(id))
            throw  new UserNotFoundException(id);

        userService.deleteUserById(id);
        return String.format("User with id %d has been deleted",id);
    }
}

