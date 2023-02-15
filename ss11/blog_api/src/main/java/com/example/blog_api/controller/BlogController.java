package com.example.blog_api.controller;


import com.example.blog_api.model.Blog;
import com.example.blog_api.service.IBlogService;
import com.example.blog_api.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RestController
@RequestMapping("api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity showById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }


}
