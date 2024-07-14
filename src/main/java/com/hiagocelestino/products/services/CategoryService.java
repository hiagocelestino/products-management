package com.hiagocelestino.products.services;

import com.hiagocelestino.products.dtos.RequestCategoryDTO;
import com.hiagocelestino.products.dtos.ResponseCategoryDTO;
import com.hiagocelestino.products.models.Category;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.repositories.CategoryRepository;
import com.hiagocelestino.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRespository;

    @Autowired
    private ProductRepository productRepository;

    public List<Category> findAll() {
        return this.categoryRespository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return this.categoryRespository.findById(id);
    }

    public Category create(RequestCategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName());
        return this.categoryRespository.save(category);
    }

    public Category update(Long id, RequestCategoryDTO categoryDTO) {
        Category category = this.findById(id).orElseThrow();
        category.setName(categoryDTO.getName());
        return this.categoryRespository.save(category);
    }

    public void delete(Long id) {
        this.findById(id).orElseThrow();
        this.categoryRespository.deleteById(id);
    }

    public List<Product> findProductsCategory(Long id) {
        return this.productRepository.findByCategoryId(id);
    }
}
