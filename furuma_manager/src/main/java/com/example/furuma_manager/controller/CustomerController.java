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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showAll(@PageableDefault(size = 5,page = 0, sort = "isDelete" , direction = Sort.Direction.DESC)Pageable pageable, Model model){
        Page<Customer> page=customerService.findAll(pageable);
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypeList);
        model.addAttribute("customers",page);
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customer/list";
    }@PostMapping("create")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        customer.setDelete(true);
        boolean check= customerService.save(customer);
        if (check){
            redirectAttributes.addFlashAttribute("mess","fail");
        } redirectAttributes.addFlashAttribute("mess","success");
        return "redirect:/customer";
    }
}
