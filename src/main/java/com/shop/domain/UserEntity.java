package com.shop.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dob;
    @OneToOne
    private ShopCartEntity shopCartEntity;
    @OneToOne
    private AddressEntity addressEntity;
    @OneToOne
    private WishListEntity wishListEntity;
    @OneToMany
    private List<OrderEntity> orderEntities;
}
