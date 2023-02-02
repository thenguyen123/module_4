package com.example.email.service.impl;


import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;
import com.example.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService {
@Autowired
    IEmailRepository emailRepository;
    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public boolean update(Email email) {
        return emailRepository.update(email);
    }
}
