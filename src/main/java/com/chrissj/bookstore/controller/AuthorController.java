package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String authorHome(Model model){
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "author/author_home";
    }
}
