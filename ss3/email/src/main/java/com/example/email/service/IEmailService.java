package com.example.email.service;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailService {
    Email findById(int id);
    List<Email> findAll();
    boolean update(Email email);
}
