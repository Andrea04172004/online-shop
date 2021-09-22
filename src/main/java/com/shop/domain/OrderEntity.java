package com.shop.domain;

import com.shop.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    private double orderPrice;
    @OneToMany
    private Set<LineItemEntity> lineItemEntitySet;
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserEntity userEntity;
    @Column
    private LocalDate created;
}
