package com.example.bai_tap.repository;

import com.example.bai_tap.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserNameContaining(String name);
}
