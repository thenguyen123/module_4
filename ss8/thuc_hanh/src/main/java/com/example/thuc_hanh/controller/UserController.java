package com.example.thuc_hanh.controller;

import com.example.thuc_hanh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView show(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }@PostMapping("/validation")
    public ModelAndView check(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("list");
        }return new ModelAndView("result");
    }
}
