package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String showList(@CookieValue(name = "productId", required = false, defaultValue = "-1") int id, Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productList);
        return "list";

    }

    @GetMapping("/view")
    public String showView(@RequestParam int id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id));
        return "detail";

    }

    @GetMapping("/add")
    public String showAdd(@RequestParam int id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";

    }

    @GetMapping("/subtraction")
    public String showCart(@RequestParam int id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.subtraction(productDto);
        }
        return "redirect:/cart";

    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.delete(productDto);
        return "redirect:/cart";
    }

}
