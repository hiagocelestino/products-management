package com.hiagocelestino.products.controllers;

import com.hiagocelestino.products.dtos.RequestProductDTO;
import com.hiagocelestino.products.dtos.ResponseCategoryDTO;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "price") String sortBy,
                                 @RequestParam(defaultValue = "asc") String sortDirection) {
        return this.productService.findAll(pageNo, pageSize, sortBy, sortDirection);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@Valid @RequestBody RequestProductDTO productDTO) {
        Product product = this.productService.create(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Optional<Product> product = this.productService.findById(id);
        if (product.isPresent()) {
            Product categoryEntity = product.get();
            return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @Valid @RequestBody RequestProductDTO productDTO) {
        Product product = this.productService.update(id, productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCategoryDTO> delete(@PathVariable("id") Long id) {
        this.productService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
