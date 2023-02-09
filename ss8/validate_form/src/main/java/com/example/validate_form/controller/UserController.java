package com.example.validate_form.controller;

import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;

import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView showList() {
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("listUser",userService.findAll());
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }



    @PostMapping("/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
           model.addAttribute("userDto",userDto);
           return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Success");
        return "redirect:/user";
    }
    @GetMapping("/create")
    public  ModelAndView showForm(){
        return new ModelAndView("create","userDto",new UserDto());
    }
}
