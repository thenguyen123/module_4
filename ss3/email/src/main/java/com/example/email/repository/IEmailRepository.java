package com.example.email.repository;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    boolean update(Email email);
    Email findById(int id);
    List<Email> findAll();
}
