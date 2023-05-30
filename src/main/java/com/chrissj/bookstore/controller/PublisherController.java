package com.chrissj.bookstore.controller;

import com.chrissj.bookstore.model.Publisher;
import com.chrissj.bookstore.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add")
    public String addPublisher(Model model){
        return "publisher/publisher_add";
    }

    @PostMapping("/add")
    public String addPublisherPost(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "address") String address){
        if(name.isEmpty() || address.isEmpty()){
            return "publisher/publisher_add";
        }
        try {
            publisherService.add(name.trim().toLowerCase(), address.trim().toLowerCase());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/publisher";
    }
}
