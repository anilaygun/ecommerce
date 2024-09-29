package com.corenil.ecommerce.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal unitPrice;
    @Column(name = "stock")
    private int unitInStock;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCarts;

}
