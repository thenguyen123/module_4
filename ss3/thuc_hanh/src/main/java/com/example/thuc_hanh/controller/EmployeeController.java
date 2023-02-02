package com.example.thuc_hanh.controller;

import com.example.thuc_hanh.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class EmployeeController {
@RequestMapping (value = "showForm",method = RequestMethod.GET)
    public String showList(Model model){
    model.addAttribute("employee",new Employee());
        return "/employee/create";
    }
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,Model model){
    model.addAttribute("name",employee.getName());
    model.addAttribute("contactNumber",employee.getContactNumber());
    model.addAttribute("id",employee.getId());
    return "/employee/list";
    }
}
