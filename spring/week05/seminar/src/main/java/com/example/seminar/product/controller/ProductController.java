package com.example.seminar.product.controller;

import com.example.seminar.product.dto.ProductResponse;
import com.example.seminar.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/jpa")
    public List<ProductResponse> findTop10ExpensiveProducts() {
        return productService.findTop10ExpensiveProducts();
    }

    @GetMapping("/jpql")
    public List<ProductResponse> findTop5AffordableAndWellStockedProducts() {
        return productService.findTop5AffordableAndWellStockedProducts();
    }
}
