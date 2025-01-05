package com.nazaire.product_crud.controllers;

import com.nazaire.product_crud.models.Users;
import com.nazaire.product_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }
}
