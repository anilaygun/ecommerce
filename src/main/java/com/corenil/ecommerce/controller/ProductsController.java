package com.corenil.ecommerce.controller;

import com.corenil.ecommerce.dto.product.CreateProductDto;
import com.corenil.ecommerce.dto.product.ProductResponseDto;
import com.corenil.ecommerce.dto.product.UpdateProductDto;
import com.corenil.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductsController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("{name}")
    public ResponseEntity<List<ProductResponseDto>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getByName(name));
    }

    @GetMapping("/id{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable @Valid int id) {
        ProductResponseDto responseDto = productService.getById(id);

        if (responseDto != null) {
            return new ResponseEntity<ProductResponseDto>(responseDto, HttpStatus.OK);
        }
        return new ResponseEntity<ProductResponseDto>(responseDto, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> add(@RequestBody @Valid CreateProductDto createProductDto) {
        if (createProductDto != null) {
            ProductResponseDto productResponseDto = productService.add(createProductDto);
            return new ResponseEntity<ProductResponseDto>(productResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<ProductResponseDto>(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> update(@RequestBody @Valid UpdateProductDto updateProductDto) {
        ProductResponseDto productResponseDto = productService.update(updateProductDto);
        if (productResponseDto != null) {
            return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ProductResponseDto deletedProduct = productService.getById(id);
        if (deletedProduct != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
