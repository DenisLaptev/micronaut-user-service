package com.udemy.service;

import com.udemy.client.Preference;
import com.udemy.client.PreferenceClient;
import com.udemy.exception.UserNotFoundException;
import com.udemy.model.User;
import com.udemy.model.UserResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserServiceListImpl implements UserService{

    private final PreferenceClient preferenceClient;

    private List<User> users = new ArrayList<>();

    @Inject
    public UserServiceListImpl(PreferenceClient preferenceClient) {
        this.preferenceClient = preferenceClient;
    }

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
        return userToUpdate;
    }

    @Override
    public void deleteUser(int id) {
        User userToDelete = getUser(id);
        users.remove(userToDelete);
    }

    @Override
    public long getUserCount() {
        return users.size();
    }
}
