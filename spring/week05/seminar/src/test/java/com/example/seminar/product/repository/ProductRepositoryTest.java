package com.example.seminar.product.repository;

import com.example.seminar.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.saveAll(List.of(
                Product.create("볼펜", 1_000, 30),
                Product.create("젤펜", 2_000, 50),
                Product.create("만년필", 15_000, 10),
                Product.create("노트", 3_000, 20),
                Product.create("연필", 800, 100),
                Product.create("형광펜", 1_500, 70)
        ));
    }

    @Test
    void JPA로_가장_비싼_상품을_가격_내림차순으로_조회한다() {
        List<Product> result =
                productRepository.findByOrderByPriceDesc(PageRequest.of(0, 10));

        assertThat(result)
                .extracting(Product::getPrice)
                .containsExactly(15_000, 3_000, 2_000, 1_500, 1_000, 800);
    }

    @Test
    void JPQL로_가격이_2000원_이하인_상품을_재고_내림차순으로_조회한다() {
        List<Product> result =
                productRepository.findTop5AffordableAndWellStocked(PageRequest.of(0, 5));

        assertThat(result)
                .extracting(Product::getName)
                .containsExactly("연필", "형광펜", "젤펜", "볼펜");
    }

    @Test
    void QueryDSL로_이름에_펜이_들어간_저렴한_상품_Top10을_조회한다() {
        List<Product> result =
                productRepository.findTop10PenProductsOrderByPriceAsc();

        assertThat(result)
                .extracting(Product::getName)
                .containsExactly("볼펜", "형광펜", "젤펜");
        assertThat(result)
                .extracting(Product::getPrice)
                .containsExactly(1_000, 1_500, 2_000);
    }
}
