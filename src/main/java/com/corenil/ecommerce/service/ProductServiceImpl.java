package com.corenil.ecommerce.service;

import com.corenil.ecommerce.dto.product.CreateProductDto;
import com.corenil.ecommerce.dto.product.ProductResponseDto;
import com.corenil.ecommerce.dto.product.UpdateProductDto;
import com.corenil.ecommerce.entity.Product;
import com.corenil.ecommerce.mapper.ProductMapper;
import com.corenil.ecommerce.repository.ProductRepository;
import com.corenil.ecommerce.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;

    @Override
    @Cacheable(value = "product", key = "#id")
    public ProductResponseDto getById(int id) {
        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(productRepository.getReferenceById(id));
        return responseDto;
    }

    @Override
    @Cacheable(value = "products")
    public List<ProductResponseDto> getAll() {
        List<ProductResponseDto> responseDtos = ProductMapper.INSTANCE.productDtoListFromProductList(productRepository.findAll());
        return responseDtos;
    }

    @Override
    @Cacheable(value = "products")
    public List<ProductResponseDto> getByName(String name) {
        List<ProductResponseDto> responseDtos = ProductMapper.INSTANCE.productDtoListFromProductList(productRepository.findByNameLikeIgnoreCase("%" + name + "%"));
        return responseDtos;
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public ProductResponseDto add(CreateProductDto createProductDto) {
        productBusinessRules.productWithSameNameShouldNotExist(createProductDto.getName());

        Product product = ProductMapper.INSTANCE.productFromCreateDto(createProductDto);
        productRepository.save(product);

        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(product);
        return responseDto;
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public ProductResponseDto update(UpdateProductDto updateProductDto) {
        Product product = ProductMapper.INSTANCE.productFromUpdateDto(updateProductDto);
        productRepository.save(product);

        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(product);
        return responseDto;
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
