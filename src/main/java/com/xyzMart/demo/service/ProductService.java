package com.xyzMart.demo.service;

import com.xyzMart.demo.model.ProductRequest;
import com.xyzMart.demo.model.ProductResponse;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<ProductResponse> getProduct(ProductRequest productRequest);
}
