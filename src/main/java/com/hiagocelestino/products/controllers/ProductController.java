package com.hiagocelestino.products.controllers;

import com.hiagocelestino.products.dtos.RequestCategoryDTO;
import com.hiagocelestino.products.dtos.RequestProductDTO;
import com.hiagocelestino.products.dtos.ResponseCategoryDTO;
import com.hiagocelestino.products.dtos.ResponseProductDTO;
import com.hiagocelestino.products.models.Product;
import com.hiagocelestino.products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return this.productService.findAll();
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
