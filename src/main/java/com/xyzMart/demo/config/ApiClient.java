package com.xyzMart.demo.config;

import com.xyzMart.demo.model.BackOrderRequest;
import com.xyzMart.demo.model.BackOrderResponse;
import com.xyzMart.demo.model.ProductRequest;
import com.xyzMart.demo.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ApiClient {

    private final WebClient inventoryWebClient;

    public Mono<ProductResponse> getProduct(ProductRequest productRequest){
        return inventoryWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/getProduct")
                        .queryParam("product",productRequest.getProduct())
                        .queryParam("quantity", productRequest.getQuantity()).build())
                .retrieve()
                .bodyToMono(ProductResponse.class);
    }

    public Mono<BackOrderResponse> createBackOrder(BackOrderRequest backOrderRequest){
        return inventoryWebClient.post()
                .uri("v1/createBackOrder")
                .bodyValue(backOrderRequest)
                .retrieve()
                .bodyToMono(BackOrderResponse.class);
    }

}
