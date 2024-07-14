package com.hiagocelestino.products.dtos;

import com.hiagocelestino.products.models.Product;

public class ResponseProductDTO {
    private Long id;
    private String name;
    private Long price;
    private Integer quantity;
    private Long categoryId;

    public ResponseProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();;
    }

}
