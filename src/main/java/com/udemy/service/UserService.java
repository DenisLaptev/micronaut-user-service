package com.udemy.service;

import com.udemy.model.User;
import com.udemy.model.UserResponse;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUser(int id);
    UserResponse getUserResponse(int id);
    User updateUser(int id, User user);
    void deleteUser(int id);

    long getUserCount();
}
