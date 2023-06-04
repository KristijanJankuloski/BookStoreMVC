package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Product;
import com.chrissj.bookstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/browse")
public class BrowseController {
    private final ProductService productService;

    public BrowseController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getBrowse(Model model){
        List<Product> products= productService.getAll();
        model.addAttribute("products", products);
        return "browse";
    }
}
