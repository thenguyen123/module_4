package com.example.furuma_manager.controller;

import com.example.furuma_manager.dto.CustomerDto;
import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.model.CustomerType;
import com.example.furuma_manager.service.ICustomerService;
import com.example.furuma_manager.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        model.addAttribute("nameSearch", name);
        model.addAttribute("emailSearch", email);
        model.addAttribute("typeCustomerSearch", typeCustomer);
        model.addAttribute("customerTypes", customerTypeList);
        model.addAttribute("customers", page);
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);

        LocalDate maxAge = LocalDate.now().minusYears(18);
        LocalDate minAge = LocalDate.now().minusYears(70);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        System.out.println(minAge);
        return "customer/list";
    }

    @PostMapping("create")
    public String save(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                       @RequestParam(defaultValue = "", required = false) String nameSearch, @RequestParam(defaultValue = "", required = false) String emailSearch,
                       @RequestParam(defaultValue = "", required = false) String typeCustomerSearch,
                       @PageableDefault(size = 5, page = 0) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {

        if(customerDto.getDayOfBrith()==""){
            return "redirect:/customer";
        }
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {

            Page<Customer> page = customerService.findAll(nameSearch, emailSearch, typeCustomerSearch, pageable);
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("emailSearch", emailSearch);
            model.addAttribute("typeCustomerSearch", typeCustomerSearch);
            model.addAttribute("customerTypes", customerTypeList);
            model.addAttribute("customers", page);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("hasedit", "true");
            return "customer/list";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        String flag = customerService.checkData(customer.getEmail(), customer.getIdCard(), customer.getPhoneNumber());
        String mess = "success";
        if (flag != null) {
            redirectAttributes.addFlashAttribute("mess", flag);
            return "redirect:/customer";
        }
        boolean check = customerService.save(customer);
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer";
    }


    @PostMapping("delete")
    public String deleteById(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        boolean flag=customerService.checkId(idDelete);
        if(flag){
            boolean check = customerService.deleteById(idDelete);
            redirectAttributes.addFlashAttribute("mess", "success");
            if (!check) {
                redirectAttributes.addFlashAttribute("mess", "fail");
            }
        }return "redirect:/customer";


    }

    @PostMapping("edit")
    public String update(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                         @RequestParam(defaultValue = "", required = false) String nameSearch, @RequestParam(defaultValue = "", required = false) String emailSearch,
                         @RequestParam(defaultValue = "", required = false) String typeCustomerSearch,
                         @PageableDefault(size = 5, page = 0) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErr", "true");
            Page<Customer> page = customerService.findAll(nameSearch, emailSearch, typeCustomerSearch, pageable);
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("emailSearch", emailSearch);
            model.addAttribute("typeCustomerSearch", typeCustomerSearch);
            model.addAttribute("customerTypes", customerTypeList);
            model.addAttribute("customers", page);
            model.addAttribute("customerDto", customerDto);
            return "customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        String flag = customerService.checkUpdate(customer.getId(), customer.getEmail(), customer.getIdCard(), customer.getPhoneNumber());
        String mess = "success";
        if (flag != null) {
            redirectAttributes.addFlashAttribute("mess", flag);
            return "redirect:/customer";
        }
        boolean check = customerService.update(customer);
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer";

    }
}
