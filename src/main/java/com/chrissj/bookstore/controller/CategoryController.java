package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Category;
import com.chrissj.bookstore.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String categoryHome(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "category/category-home";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        return "category/category-add";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "name") String name){
        if(name.isBlank()){
            return "category/category-add";
        }
        try{
            Category category = new Category(name);
            categoryService.add(category);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/category";
    }
}
