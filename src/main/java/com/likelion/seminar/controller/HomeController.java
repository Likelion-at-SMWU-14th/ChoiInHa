package com.likelion.seminar.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("home/{color}")
    public String home(
            @PathVariable String color, Model page){
        page.addAttribute("username", "likelion");
        page.addAttribute("color",color);
        return "home";
    }
}
