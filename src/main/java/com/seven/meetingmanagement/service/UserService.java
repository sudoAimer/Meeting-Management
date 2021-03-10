package com.seven.meetingmanagement.service;

import com.seven.meetingmanagement.dao.UserDao;
import com.seven.meetingmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public void saveUser(User user)
    {
        dao.save(user);
    };

    public Optional<User> findByUsername(String username)
    {
        return dao.findById(username);
    }
}

