package com.example.seminar.product.service;

import com.example.seminar.product.dto.ProductResponse;
import com.example.seminar.product.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findTop10ExpensiveProducts() {
        return productRepository.findByOrderByPriceDesc(PageRequest.of(0, 10))
                .stream()
                .map(ProductResponse::from)
                .toList();
    }

    public List<ProductResponse> findTop5AffordableAndWellStockedProducts() {
        return productRepository.findTop5AffordableAndWellStocked(PageRequest.of(0, 5))
                .stream()
                .map(ProductResponse::from)
                .toList();
    }
}
