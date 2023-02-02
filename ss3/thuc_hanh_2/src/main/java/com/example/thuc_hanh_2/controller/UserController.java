package com.example.thuc_hanh_2.controller;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;
import com.example.thuc_hanh_2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/home")
            public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home","login",new Login());
return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user=userService.check(login);
        if(user==null){
            ModelAndView modelAndView=new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("list","user",user);
            return modelAndView;
        }
    }

}
