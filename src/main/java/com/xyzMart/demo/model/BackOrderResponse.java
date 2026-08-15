package com.xyzMart.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackOrderResponse {
    private String backorderId;
    private String status;
    private String estimatedDate;
}
