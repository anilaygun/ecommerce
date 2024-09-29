package com.corenil.ecommerce.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto implements Serializable {
    private int id;
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
