package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    String[][] array = {{"Xin chào", "hello"}, {"tuổi", "age"}, {"year", "năm"}};

    @GetMapping("/dictionary")
    public String homeDictionary() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String resultDictionary(@RequestParam String word, Model model) {
        String result = "Not find";
        for (int i = 0; i < array.length; i++) {
            if (word.equals(array[i][1])) {
                result = array[i][0];
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("word",word);
        return "dictionary";

    }
}
