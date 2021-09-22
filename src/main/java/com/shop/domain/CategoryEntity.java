package com.shop.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private String name;
    @Column
    private LocalDateTime created;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany (fetch = FetchType.LAZY)
    private Set<ProductEntity> productEntities = new HashSet<>();
}
