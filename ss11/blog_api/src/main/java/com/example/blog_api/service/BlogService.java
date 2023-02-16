package com.example.blog_api.service;

import com.example.blog_api.model.Blog;
import com.example.blog_api.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
    blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
         blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findByNameContaining(String name,Pageable pageable) {
        return blogRepository.findByNameContaining(name,pageable);
    }


}
