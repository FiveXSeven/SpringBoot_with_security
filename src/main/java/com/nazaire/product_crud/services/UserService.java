package com.nazaire.product_crud.services;


import com.nazaire.product_crud.models.Users;
import com.nazaire.product_crud.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users registerUser(Users user) {
        return userRepo.save(user);
    }
}
