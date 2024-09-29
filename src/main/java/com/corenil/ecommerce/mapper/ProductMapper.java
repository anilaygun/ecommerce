package com.corenil.ecommerce.mapper;

import com.corenil.ecommerce.dto.product.CreateProductDto;
import com.corenil.ecommerce.dto.product.ProductResponseDto;
import com.corenil.ecommerce.dto.product.UpdateProductDto;
import com.corenil.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class); // -> Bu, ProductMapper arayüzünün bir instance'ını almak için kullanılır. Bu sayede mapper'a herhangi bir noktada erişilebilir ve nesneler arasında dönüştürme işlemleri yapılabilir.

    //Request
    @Mapping(target = "category.id", source = "categoryId")
    Product productFromCreateDto(CreateProductDto createProductDto);

    @Mapping(target = "category.id", source = "categoryId")
    Product productFromUpdateDto(UpdateProductDto updateProductDto);


    //Response
    @Mapping(target = "categoryId", source = "category.id")
    ProductResponseDto productDtoFromProduct(Product product);

    @Mapping(target = "categoryId", source = "category.id")
    List<ProductResponseDto> productDtoListFromProductList(List<Product> products);
}
