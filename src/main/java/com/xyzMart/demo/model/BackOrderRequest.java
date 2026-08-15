package com.xyzMart.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BackOrderRequest {
    private String customerId;
    private String orderId;
    private String product;
    private Integer quantity;
    private String customerLoyalty;
}
