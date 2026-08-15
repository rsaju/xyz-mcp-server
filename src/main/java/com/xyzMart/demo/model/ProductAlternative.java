package com.xyzMart.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductAlternative {
    private String sku;
    private String name;
    private BigDecimal price;
    private Integer availableQuantity;
}
