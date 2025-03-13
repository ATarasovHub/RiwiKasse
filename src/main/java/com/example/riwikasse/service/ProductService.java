package com.example.riwikasse.service;

import com.example.riwikasse.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public List<Product> getAll() {
        return products;
    }

    public int calculateTotal(List<Product> items) {
        return items.stream().mapToInt(Product::getPrice).sum();
    }
}
