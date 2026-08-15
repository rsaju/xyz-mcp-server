package com.xyzMart.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {
    private String product;
    private Integer quantity;
}
