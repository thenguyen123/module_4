package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(int id);
    void update(Blog blog);
    Blog findById(int id);
    Page<Blog> findByNam(String name, Pageable pageable);
}
