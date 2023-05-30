package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Publisher;
import com.chrissj.bookstore.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String publisherHome(Model model){
        List<Publisher> publishers = publisherService.getAll();
        model.addAttribute("publishers", publishers);
        return "publisher/publisher_home";
    }
}
