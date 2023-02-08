package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("category", categoryService.findAll());
        modelAndView.addObject("newCategory", new Category());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int deleteId) {
        categoryService.delete(deleteId);
        return "redirect:/category";

    }

    @PostMapping("/create")
    public String saveCategory(Category newCategory) {
        categoryService.save(newCategory);
        return "redirect:/category";

    }

    @PostMapping("/edit")
    public String edit(Category newCategory) {
        categoryService.save(newCategory);
        return "redirect:/category";
    }@GetMapping("/view")
    public  ModelAndView showView(@RequestParam int id){
        ModelAndView modelAndView=new ModelAndView("category/view");
       Category category=categoryService.findById(id);
 Set<Blog> set=category.getBlog();
 List<Blog> list=new ArrayList<>(set);
        modelAndView.addObject("category",category);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
