package com.corenil.ecommerce.repository;

import com.corenil.ecommerce.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
}
