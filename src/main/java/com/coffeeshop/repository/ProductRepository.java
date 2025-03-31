package com.coffeeshop.repository;

import com.coffeeshop.model.Product;
import com.coffeeshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAvailableTrue();
    List<Product> findByCategory(Category category);
    @Query("SELECT p FROM Product p " +
            "WHERE LOWER(p.name) LIKE LOWER(concat('%', :namePart, '%')) " +
            "AND p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> searchProducts(
            @Param("namePart") String namePart,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice
    );
}
