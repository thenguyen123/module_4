package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Blog> list = blogService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update", "blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create", "blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("mess", "Thêm mới thành công");
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView showFind(@RequestParam int id){
        Blog blog=blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/view","blog",blog);
        return modelAndView;
    }@PostMapping("/delete")
    public String deleteBlog(@RequestParam int deleteId){
        blogService.delete(deleteId);
        return "redirect:/blog";
    }
}
