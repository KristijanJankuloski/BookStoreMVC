package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.service.AuthorService;
import com.chrissj.bookstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {
    private final AuthorService authorService;
    private final ProductService productService;

    public AuthorController(AuthorService authorService, ProductService productService) {
        this.authorService = authorService;
        this.productService = productService;
    }

    @GetMapping
    public String authorHome(Model model){
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "author/author_home";
    }

    @GetMapping("/add")
    public String addAuthor(Model model){
        return "author/author_add";
    }

    @PostMapping("/add")
    public String addAuthorPost(@RequestParam(name = "name") String name){
        if(name.isEmpty()){
            return "author/author_add";
        }
        try{
            authorService.add(name.trim());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(Model model, @PathVariable int id){
        try{
            Author author = this.authorService.getById(id);
            model.addAttribute("author", author);
            return "author/author_edit";
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }

    @PostMapping("/edit/{id}")
    public String editAuthorPost(@PathVariable int id, @RequestParam(name = "name") String name){
        try{
            authorService.update(id, name);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(Model model, @PathVariable int id){
        try{
            Author author = this.authorService.getById(id);
            model.addAttribute("author", author);
            return "author/author_delete";
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }

    @PostMapping("/delete/{id}")
    public String deleteAuthorPost(@PathVariable int id){
        try {
            if(this.productService.countProductsWithAuthor(id) > 0){
                return "redirect:/admin/author";
            }
            this.authorService.deleteById(id);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/author";
    }
}
