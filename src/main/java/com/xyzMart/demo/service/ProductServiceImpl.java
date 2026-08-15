package com.xyzMart.demo.service;

import com.xyzMart.demo.config.ApiClient;
import com.xyzMart.demo.model.ProductRequest;
import com.xyzMart.demo.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ApiClient apiClient;
    @Override
    public Mono<ProductResponse> getProduct(ProductRequest productRequest) {
        validateRequest(productRequest);
        return apiClient.getProduct(productRequest);

    }

    private void validateRequest(ProductRequest productRequest){
        if(null != productRequest.getQuantity() && productRequest.getQuantity() == 0){
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }
}
