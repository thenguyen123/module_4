package com.example.thuc_hanh_2.service;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;

public interface IUserService {
    User check(Login login);
}
