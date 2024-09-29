package com.corenil.ecommerce.rules;

import com.corenil.ecommerce.core.exception.type.BusinessException;
import com.corenil.ecommerce.entity.Product;
import com.corenil.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository productRepository;

    public void productWithSameNameShouldNotExist(String name) {
        Optional<Product> product = productRepository
                .findByNameIgnoreCase(name);
        if (product.isPresent())
            throw new BusinessException("Böyle bir ürün zaten var.");
    }

    public void productWithIdShouldExist(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new BusinessException("Böyle bir ürün yok.");
    }
}