package com.corenil.ecommerce.service;

import com.corenil.ecommerce.dto.product.CreateProductDto;
import com.corenil.ecommerce.dto.product.ProductResponseDto;
import com.corenil.ecommerce.dto.product.UpdateProductDto;
import com.corenil.ecommerce.entity.Product;
import com.corenil.ecommerce.mapper.ProductMapper;
import com.corenil.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto getById(int id) {
        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(productRepository.getReferenceById(id));
        return responseDto;
    }

    @Override
    public List<ProductResponseDto> getAll() {
        List<ProductResponseDto> responseDtos = ProductMapper.INSTANCE.productDtoListFromProductList(productRepository.findAll());
        return responseDtos;
    }

    @Override
    public List<ProductResponseDto> getByName(String name) {
        List<ProductResponseDto> responseDtos = ProductMapper.INSTANCE.productDtoListFromProductList(productRepository.findByNameLikeIgnoreCase("%" + name + "%"));
        return responseDtos;
    }

    @Override
    public ProductResponseDto add(CreateProductDto createProductDto) {
        Product product = ProductMapper.INSTANCE.productFromCreateDto(createProductDto);
        productRepository.save(product);

        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(product);
        return responseDto;
    }

    @Override
    public ProductResponseDto update(UpdateProductDto updateProductDto) {
        Product product = ProductMapper.INSTANCE.productFromUpdateDto(updateProductDto);
        productRepository.save(product);

        ProductResponseDto responseDto = ProductMapper.INSTANCE.productDtoFromProduct(product);
        return responseDto;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
