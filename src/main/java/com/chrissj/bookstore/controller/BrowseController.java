package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Category;
import com.chrissj.bookstore.model.Product;
import com.chrissj.bookstore.service.CategoryService;
import com.chrissj.bookstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/browse")
public class BrowseController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public BrowseController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getBrowse(Model model){
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "browse";
    }
    @GetMapping("/{category}")
    public String getBrowseCategory(@PathVariable String category){
        return "browse";
    }
}
