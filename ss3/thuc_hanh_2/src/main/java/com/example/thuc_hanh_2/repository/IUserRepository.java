package com.example.thuc_hanh_2.repository;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;

public interface IUserRepository {
    User check(Login login);
}
