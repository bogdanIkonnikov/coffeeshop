package com.coffeeshop.controller;

import com.coffeeshop.dto.CategoryDTO;
import com.coffeeshop.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories", description = "Returns list of all categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }


}