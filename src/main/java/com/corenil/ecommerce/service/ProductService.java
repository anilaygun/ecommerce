package com.corenil.ecommerce.service;

import com.corenil.ecommerce.dto.product.CreateProductDto;
import com.corenil.ecommerce.dto.product.ProductResponseDto;
import com.corenil.ecommerce.dto.product.UpdateProductDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getById(int id);

    List<ProductResponseDto> getAll();

    List<ProductResponseDto> getByName(String name);

    ProductResponseDto add(CreateProductDto createProductDto);

    ProductResponseDto update(UpdateProductDto updateProductDto);

    void delete(int id);

}
