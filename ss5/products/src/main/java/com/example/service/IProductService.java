package com.example.service;

import com.example.model.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll();
    boolean save(Products products);
    boolean update(Products products);
    Products findByID(int id);
    void delete(int id);
    List<Products> search(String name);
}
