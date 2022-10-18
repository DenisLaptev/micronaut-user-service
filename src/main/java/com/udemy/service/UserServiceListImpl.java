package com.udemy.service;

import com.udemy.exception.UserNotFoundException;
import com.udemy.model.User;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserServiceListImpl implements UserService{

    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = getUser(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setMobileNumber(user.getMobileNumber());
        userToUpdate.setEmail(user.getEmail());
        return userToUpdate;
    }

    @Override
    public void deleteUser(int id) {
        User userToDelete = getUser(id);
        users.remove(userToDelete);
    }
}
