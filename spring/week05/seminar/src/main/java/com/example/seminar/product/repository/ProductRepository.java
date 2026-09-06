package com.example.seminar.product.repository;

import com.example.seminar.product.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    List<Product> findByOrderByPriceDesc(Pageable pageable);

    @Query("""
            select p
            from Product p
            where p.price <= 2000
            order by p.stockQuantity desc
            """)
    List<Product> findTop5AffordableAndWellStocked(Pageable pageable);
}
