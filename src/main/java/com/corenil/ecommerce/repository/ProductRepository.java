package com.corenil.ecommerce.repository;

import com.corenil.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 1. Derived Method Naming
    List<Product> findByNameLikeIgnoreCase(String name);

    Optional<Product> findByNameIgnoreCase(String name);
}
