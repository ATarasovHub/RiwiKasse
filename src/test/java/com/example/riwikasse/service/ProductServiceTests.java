package com.example.riwikasse.service;

import com.example.riwikasse.entity.Product;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTests {

    private final ProductService productService = new ProductService();

    @Test
    void calculateTotal_ReturnsSumOfPrices() {
        List<Product> items = Arrays.asList(
                Product.builder().id(1).name("Item1").price(10).build(),
                Product.builder().id(2).name("Item2").price(20).build(),
                Product.builder().id(3).name("Item3").price(30).build()
        );

        int total = productService.calculateTotal(items);

        assertEquals(60, total);
    }
}
