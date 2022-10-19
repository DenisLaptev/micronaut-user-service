package com.udemy.service;

import com.udemy.client.Preference;
import com.udemy.client.PreferenceClient;
import com.udemy.exception.UserNotFoundException;
import com.udemy.model.User;
import com.udemy.model.UserResponse;
import com.udemy.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;


@Singleton
public class UserServiceDBImpl implements UserService {

    private final UserRepository userRepository;

    private final PreferenceClient preferenceClient;

    @Inject
    public UserServiceDBImpl(UserRepository userRepository, PreferenceClient preferenceClient) {
        this.userRepository = userRepository;
        this.preferenceClient = preferenceClient;
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
    public long getUserCount(){
        return userRepository.count();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public UserResponse getUserResponse(int id) {
        User user = getUser(id);
        Optional<Preference> optionalPreference = preferenceClient.getUserPreference(id);
        Preference preference = optionalPreference.orElse(null);

        return UserResponse.builder()
                .user(user)
                .preference(preference)
                .build();
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