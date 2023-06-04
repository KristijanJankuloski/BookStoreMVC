package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private final AuthService authService;

    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getSignUpPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("error", error);
        return "signup";
    }

    @PostMapping
    public String signUpUser(@RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "repeatedPassword") String repeatedPassword){
        try{
            this.authService.signUpUser(username, password, repeatedPassword);
            return "redirect:/login?info=SuccessfulRegistration";
        }
        catch (Exception ex){
            return "redirect:/signup?error=" + ex.getLocalizedMessage();
        }
    }
}
