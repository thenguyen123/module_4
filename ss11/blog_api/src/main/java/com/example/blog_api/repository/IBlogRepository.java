package com.example.blog_api.repository;


import com.example.blog_api.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {
Page<Blog> findByNameContaining(String name,Pageable pageable);
}
