package com.example.riwikasse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String getProducts(Model model) {

        model.addAttribute("message", "Welcome to the Product Page!");
        return "products";
    }
}
