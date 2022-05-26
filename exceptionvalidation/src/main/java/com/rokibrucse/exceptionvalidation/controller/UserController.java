package com.rokibrucse.exceptionvalidation.controller;

import com.rokibrucse.exceptionvalidation.exception.UniqueFieldException;
import com.rokibrucse.exceptionvalidation.model.User;
import com.rokibrucse.exceptionvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UniqueFieldException {
        User email = userService.findUserByEmail(user.getEmail());
        if (email != null) {
            throw new UniqueFieldException("email have already been used");
        }
        User username = userService.findUserByName(user.getName());
        if (username != null) {
            throw new UniqueFieldException("name have already been used");
        }
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

}
