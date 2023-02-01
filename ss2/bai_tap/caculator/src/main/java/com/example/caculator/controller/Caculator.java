package com.example.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Caculator {
    @GetMapping("/caculator")
    public String showCaculator() {
        return "/result";
    }

    @PostMapping("/result")
    public ModelAndView resultCaculator(@RequestParam String caculator, @RequestParam double numberOne, @RequestParam double numberTwo) {
        ModelAndView modelAndView = new ModelAndView("/result");
        double result = 0;
        String mess = caculator;
        switch (caculator) {
            case "Addition":
                result = numberOne + numberTwo;
                break;
            case "Subtraction":
                result = numberOne - numberTwo;
                break;
            case "Multiplication":
                result = numberOne * numberTwo;
                break;
            case "Division":
                if (numberTwo != 0) {
                    result = numberOne / numberTwo;
                    break;
                } else {
                    mess = "Division by ";
                    break;
                }

        }
        modelAndView.addObject("result", result);
        modelAndView.addObject("mess", mess);
        return modelAndView;
    }
}
