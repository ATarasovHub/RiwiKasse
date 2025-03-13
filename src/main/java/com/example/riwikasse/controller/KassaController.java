package com.example.riwikasse.controller;

import com.example.riwikasse.entity.Product;
import com.example.riwikasse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kassa")
@RequiredArgsConstructor
public class KassaController {

    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping("/calculate")
    public int calculate(@RequestBody List<Product> items) {
        return productService.calculateTotal(items);
    }


}

