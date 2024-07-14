package com.hiagocelestino.products.controllers;

import com.hiagocelestino.products.dtos.RequestCategoryDTO;
import com.hiagocelestino.products.dtos.ResponseCategoryDTO;
import com.hiagocelestino.products.models.Category;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@Valid @RequestBody RequestCategoryDTO categoryDTO) {
        Category category = this.categoryService.create(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") Long id) {
        Optional<Category> category = this.categoryService.findById(id);
        if (category.isPresent()) {
            Category categoryEntity = category.get();
            return ResponseEntity.ok().body(categoryEntity);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @Valid @RequestBody RequestCategoryDTO categoryDTO) {
        Category category = this.categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> findProductsCategory(@PathVariable("id") Long id) {
        List<Product> products = this.categoryService.findProductsCategory(id);
        return ResponseEntity.ok().body(products);
    }
}
