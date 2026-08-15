package com.xyzMart.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private String product;
    private Integer requestedQuantity;
    private boolean available;
    private List<ProductAlternative> alternatives;
}
