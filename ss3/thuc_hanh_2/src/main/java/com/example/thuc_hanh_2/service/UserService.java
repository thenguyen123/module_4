package com.example.thuc_hanh_2.service;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;
import com.example.thuc_hanh_2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public User check(Login login) {
        return userRepository.check(login);
    }
}
