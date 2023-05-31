package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Category;
import com.chrissj.bookstore.model.Product;
import com.chrissj.bookstore.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        return "category/category_home";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        return "category/category_add";
    }

    @PostMapping("/add")
    public String addCategoryPost(@RequestParam(name = "name") String name){
        if(name.isBlank()){
            return "category/category_add";
        }
        try{
            categoryService.add(name.trim().toLowerCase());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(Model model, @PathVariable int id){
        try{
            Category category = this.categoryService.getById(id);
            model.addAttribute("category", category);
            return "category/category_edit";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category";
    }

    @PostMapping("/edit/{id}")
    public String editCategoryPost(@PathVariable int id, @RequestParam(name = "name") String name){
        if(name.isBlank()){
            return "category/category_edit";
        }
        try {
            this.categoryService.update(id, name.trim().toLowerCase());
            return "redirect:/admin/category";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(Model model, @PathVariable int id){
        try {
            Category category = this.categoryService.getById(id);
            model.addAttribute("category", category);
            return "category/category_delete";
        } catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/admin/category";
    }
}
