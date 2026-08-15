package com.xyzMart.demo.service;

import com.xyzMart.demo.config.ApiClient;
import com.xyzMart.demo.model.BackOrderRequest;
import com.xyzMart.demo.model.BackOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BackOrderServiceImpl implements BackOrderService {
    private final ApiClient apiClient;
    @Override
    public Mono<BackOrderResponse> createBackOrder(BackOrderRequest backOrderRequest) {
        validate(backOrderRequest);
        return apiClient.createBackOrder(backOrderRequest);
    }

    private void validate(BackOrderRequest backOrderRequest){
        if(null == backOrderRequest.getQuantity() ||backOrderRequest.getQuantity() == 0){
            throw new IllegalArgumentException("Quantity mmust be greater than 0");
        }
        if(null == backOrderRequest.getCustomerId()){
            throw new IllegalArgumentException("Customer id is required!");
        }
        if(null == backOrderRequest.getOrderId()){
            throw new IllegalArgumentException("OrderId is required!");
        }
    }
}
