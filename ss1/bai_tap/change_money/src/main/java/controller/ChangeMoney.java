package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.DoubleUnaryOperator;

@Controller
public class ChangeMoney {
    @GetMapping("/change")
    public String changeHome() {
        return "/change";
    }

    @PostMapping("/change")
    public String resultChange(@RequestParam int money, @RequestParam int rate, Model model) {
        double result = money * rate;
        model.addAttribute("result", result);
        return "/change";
    }
}
