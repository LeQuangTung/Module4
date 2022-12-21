package com.example.service;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{
    private static final List<User> users = new ArrayList<>();
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
