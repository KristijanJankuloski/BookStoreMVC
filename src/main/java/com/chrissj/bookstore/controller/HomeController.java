package com.chrissj.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String getHomePage(HttpServletRequest req, HttpServletResponse res){
        return "home";
    }
}
