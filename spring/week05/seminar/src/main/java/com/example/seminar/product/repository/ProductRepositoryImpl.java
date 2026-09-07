package com.example.seminar.product.repository;

import com.example.seminar.product.domain.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.seminar.product.domain.QProduct.product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Product> findTop10PenProductsOrderByPriceAsc() {
        return queryFactory
                .selectFrom(product)
                .where(product.name.contains("펜"))
                .orderBy(product.price.asc())
                .limit(10)
                .fetch();
    }
}
