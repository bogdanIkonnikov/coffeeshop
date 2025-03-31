package com.coffeeshop.controller;

import com.coffeeshop.dto.ProductDTO;
import com.coffeeshop.model.Category;
import com.coffeeshop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Product management APIs")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @Operation(summary = "Get all products", description = "Returns sorted by name paginated list of all products")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @PageableDefault(sort = "name", direction = ASC) Pageable pageable) {
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Returns a single product by its ID")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get products by category ID", description = "Returns all products from the specified category")
    public ResponseEntity<Page<ProductDTO>> getByCategoryId(@PathVariable Long categoryId,
                                                          @PageableDefault(sort = "name", direction = ASC)
                                                          Pageable pageable) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId, pageable));
    }

    @GetMapping("/search")
    public List<ProductDTO> getProductsByNameAndPriceRange(
            @RequestParam String name,
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice
    ) {
        return productService.searchProducts(name, minPrice, maxPrice);
    }
}
