package com.example.thuc_hanh_2.controller;

import com.example.thuc_hanh_2.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {


        @GetMapping("/")
        public String showForm(Model model){
            model.addAttribute("phoneNumber", new Phone());
            return "/index";
        }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")Phone phoneNumber, BindingResult bindingResult, Model model){
        new Phone().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}
