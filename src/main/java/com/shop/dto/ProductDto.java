package com.shop.dto;

import com.shop.enums.ProductStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private Double price;
    private String description;
    private List<String> images;
    private Integer amount;
    private ProductStatus status;
    private CategoryDto categoryEntity;
}
