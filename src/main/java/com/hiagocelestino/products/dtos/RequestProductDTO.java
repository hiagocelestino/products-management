package com.hiagocelestino.products.dtos;

import com.hiagocelestino.products.models.Category;
import com.hiagocelestino.products.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RequestProductDTO {
    @NotBlank
    @Size(max=255, message = "Name cannot be greater than 255 characters")
    private String name;

    @NotNull
    private Long price;

    @NotBlank
    @Size(max=255, message = "Description cannot be greater than 255 characters")
    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long categoryId;

}
