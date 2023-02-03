package com.example.thuc_hanh.controller;

import com.example.thuc_hanh.model.Customer;
import com.example.thuc_hanh.service.CustomerService;
import com.example.thuc_hanh.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService=new CustomerService();
    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList=customerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.finById(id));
        return "/edit";
    }@PostMapping("/edit")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.finById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
}
