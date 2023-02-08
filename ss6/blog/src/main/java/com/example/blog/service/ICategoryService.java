package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    void delete(int id);
    void update(Category category);
  Category findById(int id);
    void save(Category category);
}
