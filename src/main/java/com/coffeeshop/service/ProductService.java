package com.coffeeshop.service;

import com.coffeeshop.dto.ProductDTO;
import com.coffeeshop.model.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);
    List<ProductDTO> getProductsByCategory(Category category);
    List<ProductDTO> searchProducts(String namePart, BigDecimal minPrice, BigDecimal maxPrice);
}
