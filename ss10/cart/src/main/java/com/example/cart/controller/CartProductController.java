package com.example.cart.controller;

import com.example.cart.dto.CartDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartProductController {


    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false) CartDto cartDto){
        return new ModelAndView("cart","cartDto",cartDto);
    }

}
