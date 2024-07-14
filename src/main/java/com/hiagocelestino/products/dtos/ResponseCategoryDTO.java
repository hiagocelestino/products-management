package com.hiagocelestino.products.dtos;

import com.hiagocelestino.products.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCategoryDTO {
    private Long id;
    private String name;

    public ResponseCategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
