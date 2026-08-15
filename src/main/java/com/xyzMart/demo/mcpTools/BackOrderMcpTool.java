package com.xyzMart.demo.mcpTools;

import com.xyzMart.demo.model.BackOrderRequest;
import com.xyzMart.demo.model.BackOrderResponse;
import com.xyzMart.demo.service.BackOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BackOrderMcpTool {
    private final BackOrderService backOrderService;

    @Tool(name = "submit_backorder",
    description = "submit a backorder request for a product which is unavailable at xyzMart")
    public BackOrderResponse submitBackOrder(
            @ToolParam(description = "Customer Id")
            String customerId,
            @ToolParam(description = "Order Id")
            String orderId,
            @ToolParam(description = "Product")
            String product,
            @ToolParam(description = "Quantity")
            Integer quantity,
            @ToolParam(description = "Customer loyalty")
            String customerLoyalty
    ){
        BackOrderRequest backOrderRequest = BackOrderRequest.builder()
                .customerId(customerId)
                .orderId(orderId)
                .product(product)
                .quantity(quantity)
                .customerLoyalty(customerLoyalty).build();
        return backOrderService.createBackOrder(backOrderRequest).block();

    }

}
