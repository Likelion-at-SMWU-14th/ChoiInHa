package com.example.seminar.product.repository;

import com.example.seminar.product.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findTop10PenProductsOrderByPriceAsc();
}
