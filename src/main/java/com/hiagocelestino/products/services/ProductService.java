package com.hiagocelestino.products.services;

import com.hiagocelestino.products.dtos.RequestProductDTO;
import com.hiagocelestino.products.models.Category;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.repositories.CategoryRepository;
import com.hiagocelestino.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRespository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return this.productRespository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return this.productRespository.findById(id);
    }

    public Product create(RequestProductDTO productDTO) {
        Long categoryId = productDTO.getCategoryId();
        Category category = this.categoryRepository.findById(categoryId).orElseThrow();
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
        product.setCategory(category);
        return this.productRespository.save(product);
    }

    public Product update(Long id, RequestProductDTO productDTO) {
        Product product = this.findById(id).orElseThrow();
        Long categoryId = productDTO.getCategoryId();
        Category category = this.categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return this.productRespository.save(product);
    }

    public void delete(Long id) {
        this.findById(id).orElseThrow();
        this.productRespository.deleteById(id);
    }

}
