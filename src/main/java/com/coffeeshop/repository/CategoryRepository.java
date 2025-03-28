package com.coffeeshop.repository;

import com.coffeeshop.model.Category;
import com.coffeeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}