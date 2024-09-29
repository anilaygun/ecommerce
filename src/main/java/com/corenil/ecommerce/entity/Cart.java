package com.corenil.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @OneToMany(mappedBy = "cart")
    private List<ProductCart> productCarts;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
