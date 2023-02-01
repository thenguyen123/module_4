package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichCondiments {
    @GetMapping("/sandwich")
    public String showSandwichCondiments(){
        return "/list";
    }
    @PostMapping ("/choose")
    public ModelAndView result(@RequestParam String[] sandwich){
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("sandwich",sandwich);
        return modelAndView;
    }
}
