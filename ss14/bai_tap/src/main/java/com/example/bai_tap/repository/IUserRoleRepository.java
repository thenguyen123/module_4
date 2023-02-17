package com.example.bai_tap.repository;

import com.example.bai_tap.model.AppRole;
import com.example.bai_tap.model.AppUser;
import com.example.bai_tap.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
