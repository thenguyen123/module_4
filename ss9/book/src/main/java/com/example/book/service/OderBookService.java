package com.example.book.service;

import com.example.book.model.OderBook;
import com.example.book.repository.IOderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderBookService implements IOderBookService{
    @Autowired
    IOderBookRepository oderBookRepository;

    @Override
    public OderBook findById(int id) {
        return oderBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OderBook oderBook) {
oderBookRepository.save(oderBook);
    }

    @Override
    public List<OderBook> findAll() {
        return oderBookRepository.findAll();
    }
}
