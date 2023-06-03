package com.chrissj.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String loginPage(@RequestParam(required = false) String info, @RequestParam(required = false) String error, Model model){
        model.addAttribute("info", info);
        model.addAttribute("error", error);
        return "login";
    }
}
