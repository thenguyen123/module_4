package com.example.furuma_manager.controller;

import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.model.CustomerType;
import com.example.furuma_manager.service.ICustomerService;
import com.example.furuma_manager.service.ICustomerTypeService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showAll(@RequestParam(defaultValue = "", required = false) String name, @RequestParam(defaultValue = "", required = false) String email, @RequestParam(defaultValue = "", required = false) String typeCustomer, @PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
        Page<Customer> page = customerService.findAll(name, email, typeCustomer, pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("type", typeCustomer);
        model.addAttribute("customerTypes", customerTypeList);
        model.addAttribute("customers", page);
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/list";
    }

    @PostMapping("create")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        String checkData = customerService.checkData(customer.getEmail(), customer.getIdCard(), customer.getPhoneNumber());
        if (checkData != null) {
            redirectAttributes.addFlashAttribute("error", checkData);
            redirectAttributes.addFlashAttribute("hasErr", "true");
            return "redirect:/customer";
        }
        boolean check = customerService.save(customer);
        if (!check) {
            redirectAttributes.addFlashAttribute("mess", "fail");
        }
        redirectAttributes.addFlashAttribute("mess", "success");
        return "redirect:/customer";
    }

    @PostMapping("delete")
    public String deleteById(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        boolean check = customerService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("mess", "success");
        if (!check) {
            redirectAttributes.addFlashAttribute("mess", "fail");
        }
        return "redirect:/customer";
    }

    @PostMapping("edit")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        boolean check = customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "success");
        if (!check) {
            redirectAttributes.addFlashAttribute("mess", "fail");
        }
        return "redirect:/customer";
    }

}
