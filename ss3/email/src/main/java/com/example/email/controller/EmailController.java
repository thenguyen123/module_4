package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @ModelAttribute("arrayLanguages")
    public String[] arrayLanguages(){
        return new String[]{" English", "Vietnamese", "Japanese", "Chinese"};
    }
    @ModelAttribute("arraySize")
    public int[] arraySize(){
        return new int[]{ 5, 10, 15, 25, 50, 100};
    }
    @Autowired
    IEmailService emailService;
    @GetMapping("/email")
    public ModelAndView showEmail(){
        ModelAndView modelAndView=new ModelAndView("list","list",emailService.findAll());
        return modelAndView;
    }
@GetMapping("/setting")
    public String showSetting(@RequestParam int id,Model model){
       Email email= emailService.findById(id);
       model.addAttribute("newEmail",email);
       return "/update";

}
@PostMapping("/setting")
    public String update(@ModelAttribute Email newEmail, Model model){
      boolean check=  emailService.update(newEmail);
      String mess="success";
        if(!check){
           mess="fail";
        }
        model.addAttribute("mess",mess);
        return "redirect:/email";

}
}
