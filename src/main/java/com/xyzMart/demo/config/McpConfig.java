package com.xyzMart.demo.config;

import com.xyzMart.demo.mcpTools.BackOrderMcpTool;
import com.xyzMart.demo.mcpTools.ProductMcpTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider xyzMartTools(ProductMcpTool productMcpTool, BackOrderMcpTool backOrderMcpTool){
        return MethodToolCallbackProvider.builder()
                .toolObjects(productMcpTool,backOrderMcpTool).build();
    }
}
