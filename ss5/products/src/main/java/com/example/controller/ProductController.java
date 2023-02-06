package com.example.controller;

import com.example.model.Products;
import com.example.service.IProductService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Products> list = productService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Products());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Products product, Model model, RedirectAttributes redirectAttributes) {

        boolean check = productService.save(product);
        String mess = "fail";
        if (check) {
            mess = "success";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        model.addAttribute("mess", mess);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Products product = productService.findByID(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update")
    public String update(Products product, RedirectAttributes redirectAttributes) {
        boolean check = productService.update(product);
        String mess = "fail";
        if (check) {
            mess = "success";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        Products products = productService.findByID(id);
        model.addAttribute("products", products);
        return "view";
    }

    @PostMapping("/search")
    public String findByName(@RequestParam String search, Model model) {
        List<Products> products = productService.search(search);
        String mess = "";
        if (products.size()==0) {
            mess = "Is Empty";
            model.addAttribute("message", mess);
        }

        model.addAttribute("list", products);
        return "list";
    }

    @PostMapping("/delete")
    public String show(@RequestParam int deleteId) {
        productService.delete(deleteId);
        return "redirect:/product";
    }
}
