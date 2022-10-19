package com.udemy.controller;

import com.udemy.model.User;
import com.udemy.model.UserResponse;
import com.udemy.service.UserService;
import com.udemy.service.UserServiceDBImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.validation.Valid;
import java.util.List;

@Controller("/api/users")
public class UserController {

    private final UserService userService;

//    @Inject
//    public UserController(@Named("UserServiceListImpl") UserService userService) {
//        this.userService = userService;
//    }

    @Inject
    public UserController(@Named("UserServiceDBImpl") UserService userService) {
        this.userService = userService;
    }

    @Inject
    public UserController(UserServiceDBImpl userService) {
        this.userService = userService;
    }


    //Status 201 - created entity on server
    @Post
    public HttpResponse<User> createUser(@Body @Valid User user) {
        return HttpResponse.created(userService.createUser(user));
    }

    @Get
    public HttpResponse<List<User>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

//    @Get("/{id}")
//    public HttpResponse<User> getUser(@PathVariable int id) {
//        return HttpResponse.ok(userService.getUser(id));
//    }

    @Get("/{id}")
    public HttpResponse<UserResponse> getUser(@PathVariable int id) {
        return HttpResponse.ok(userService.getUserResponse(id));
    }

    @Put("/{id}")
    public HttpResponse<User> updateUser(@PathVariable int id, @Body User user) {
        return HttpResponse.ok(userService.updateUser(id, user));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return HttpResponse.ok();
    }
}
