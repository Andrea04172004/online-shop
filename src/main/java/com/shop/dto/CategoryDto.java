package com.shop.dto;

import com.shop.domain.CategoryEntity;
import com.shop.domain.ProductEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private String name;
    private LocalDateTime created;
    private Set<ProductDto> productDtos = new HashSet<>();
}
