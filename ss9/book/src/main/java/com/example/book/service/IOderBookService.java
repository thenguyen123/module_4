package com.example.book.service;

import com.example.book.model.OderBook;

import java.util.List;

public interface IOderBookService{
    OderBook findById(int id);
    void save(OderBook oderBook);
    List<OderBook> findAll();

}
