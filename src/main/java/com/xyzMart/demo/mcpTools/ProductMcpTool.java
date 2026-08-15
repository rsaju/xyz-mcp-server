package com.xyzMart.demo.mcpTools;

import com.xyzMart.demo.model.ProductRequest;
import com.xyzMart.demo.model.ProductResponse;
import com.xyzMart.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class ProductMcpTool {
    private final ProductService productService;

    @Tool(name = "search_product",
    description = "Search xyzMart inventory for a product. Returns current availability and suitable alternatives.")
    public ProductResponse productResponse(
            @ToolParam(description = "xvzMart product")
            String product,
            @ToolParam(description = "required quantity")
            Integer quantity
    ){
        ProductRequest productRequest = ProductRequest.builder()
                .product(product)
                .quantity(quantity).build();
        return productService.getProduct(productRequest).block();
    }
}
