package com.corenil.ecommerce.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class CreateProductDto {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal unitPrice;
    @NotNull
    @PositiveOrZero
    private int unitsInStock;
    @NotNull
    @Positive
    private int categoryId;
}
