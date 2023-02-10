package com.example.validate_form.service;

import com.example.validate_form.model.User;
import com.example.validate_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
   private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean save(User user) {
        for (User  u: userRepository.findAll()) {
            if(user.getEmail().equals(u.getEmail())){
                return false;
            }
        } userRepository.save(user);
        return true;

    }
}
