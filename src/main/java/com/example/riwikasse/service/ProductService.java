package com.example.riwikasse.service;

import com.example.riwikasse.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    private void loadProducts() {
        ClassPathResource resource = new ClassPathResource("static/products.json");
        try (InputStream is = resource.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(is, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load products", e);
        }
    }

    public List<Product> getAll() {
        return products;
    }

    public int calculateTotal(List<Product> items) {
        return items.stream().mapToInt(Product::getPrice).sum();
    }
}
