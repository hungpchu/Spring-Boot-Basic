package com.example.hungpchu.ControllerAndThymeleaf.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name" , required = false, defaultValue = "Hung") String name, Model model)
    {
        model.addAttribute("name",name);
        return "hello";
    }
}
