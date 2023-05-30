package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add")
    public String addAutor(Model model){
        return "author/author_add";
    }

    @PostMapping("/add")
    public String addAutorPost(@RequestParam(name = "name") String name){
        if(name.isEmpty()){
            return "author/author_add";
        }
        try{
            authorService.add(name.trim().toLowerCase());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }
}
