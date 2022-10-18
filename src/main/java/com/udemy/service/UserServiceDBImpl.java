package com.udemy.service;

import com.udemy.exception.UserNotFoundException;
import com.udemy.model.User;
import com.udemy.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;


@Singleton
public class UserServiceDBImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceDBImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = getUser(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setMobileNumber(user.getMobileNumber());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.update(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}