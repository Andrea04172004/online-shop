package com.shop.domain;

import com.shop.enums.ProductStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String description;
    @ElementCollection
    private List<String> images;
    @Column
    private Integer amount;
    @Enumerated
    private ProductStatus status;

    @ManyToOne
    private CategoryEntity categoryEntity;
}
