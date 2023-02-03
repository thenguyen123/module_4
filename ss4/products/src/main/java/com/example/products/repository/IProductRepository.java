package com.example.products.repository;

import com.example.products.model.Products;

import java.util.List;

public interface IProductRepository {
    List<Products> findAll();
    boolean save(Products products);
    boolean update(int id,Products products);
    Products findByID(int id);
    void delete(int id);
List<Products> search(String name);
}
