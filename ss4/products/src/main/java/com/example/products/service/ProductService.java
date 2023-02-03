package com.example.products.service;

import com.example.products.model.Products;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean save(Products products) {
        return productRepository.save(products);
    }

    @Override
    public boolean update(int id, Products products) {
        return productRepository.update(id,products);
    }

    @Override
    public Products findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public void delete(int id) {
productRepository.delete(id);
    }

    @Override
    public List<Products> search(String name) {
        return productRepository.search(name);
    }
}
