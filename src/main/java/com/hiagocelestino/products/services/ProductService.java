package com.hiagocelestino.products.services;

import com.hiagocelestino.products.dtos.RequestProductDTO;
import com.hiagocelestino.products.models.Category;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.repositories.CategoryRepository;
import com.hiagocelestino.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRespository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
        Sort.Direction direction = sortDirection.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(direction, sortBy));

        return this.productRespository.findAll(paging);
    }

    public Optional<Product> findById(Long id) {
        return this.productRespository.findById(id);
    }

    public Product create(RequestProductDTO productDTO) {
        Long categoryId = productDTO.getCategoryId();
        Category category = this.categoryRepository.findById(categoryId).orElseThrow();
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(), productDTO.getQuantity());
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
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        return this.productRespository.save(product);
    }

    public void delete(Long id) {
        this.findById(id).orElseThrow();
        this.productRespository.deleteById(id);
    }
}
