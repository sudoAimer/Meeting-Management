package com.seven.meetingmanagement.controller;

import com.seven.meetingmanagement.entity.User;
import com.seven.meetingmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/register")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "")
    public void saveUser(User user)
    {
        service.saveUser(user);
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Optional<User> findById(@RequestParam(value = "username") String username)
    {
        return service.findByUsername(username);
    }

}
