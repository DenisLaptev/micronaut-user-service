package com.udemy.service;

import com.udemy.model.User;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserService {

    private List<User> users = new ArrayList<>();

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User updateUser(int id, User user) {
        User userToUpdate = getUser(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setMobileNumber(user.getMobileNumber());
        userToUpdate.setEmail(user.getEmail());
        return userToUpdate;
    }

    public void deleteUser(int id) {
        User userToDelete = getUser(id);
        users.remove(userToDelete);
    }
}
