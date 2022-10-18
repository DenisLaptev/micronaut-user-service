package com.udemy.service;

import com.udemy.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUser(int id);
    User updateUser(int id, User user);
    void deleteUser(int id);
}
