package com.example.blog_api.service;


import com.example.blog_api.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void delete(int id);

    void update(Category category);

    Category findById(int id);

    void save(Category category);
}
