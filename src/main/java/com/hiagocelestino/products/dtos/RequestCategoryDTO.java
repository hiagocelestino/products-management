package com.hiagocelestino.products.dtos;

import com.hiagocelestino.products.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestCategoryDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot be greater than 255 characters")
    private String name;

    public Category toCategory() {
        return new Category(this.name);
    }
}
