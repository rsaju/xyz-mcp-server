package com.xyzMart.demo.service;

import com.xyzMart.demo.model.BackOrderRequest;
import com.xyzMart.demo.model.BackOrderResponse;
import reactor.core.publisher.Mono;

public interface BackOrderService {

    Mono<BackOrderResponse> createBackOrder(BackOrderRequest backOrderRequest);
}
