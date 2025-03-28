package com.coffeeshop.service;

import com.coffeeshop.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
}