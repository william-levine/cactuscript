package co.cactuscript.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String home(Model model) {
        String dynamicMessage = "";
        model.addAttribute("message", dynamicMessage);
        return "index";
    }
}
