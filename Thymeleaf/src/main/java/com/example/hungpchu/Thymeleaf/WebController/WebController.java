package com.example.hungpchu.Thymeleaf.WebController;

import com.example.hungpchu.Thymeleaf.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("slogan","Welcome Hung Chu");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model)
    {
        List<Info> list = new ArrayList<>();
        list.add(new Info("Name","Hung Chu"));
        list.add(new Info("Age","22"));
        list.add(new Info("Work","Mutual of Omaha"));
        list.add(new Info("Height","1m83"));
        list.add(new Info("Weight","80 kg"));
        model.addAttribute("hungProfile",list);
        return "profile";
    }
}
