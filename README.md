# xyzMart-mcp-server

## Objectives

The primary objectives of this project are:

1. Expose xyzMart inventory functionality to an AI agent.
2. Provide a well-defined MCP tool interface.
3. Keep the AI agent isolated from internal enterprise APIs.
4. Secure API access using OAuth2.
5. Maintain separation between AI reasoning and enterprise business logic.

# -----ARCHITECTURE-----

                            Gemini Agent 
                                |
                                V
                               MCP
                                |
                                V 
                            xyzMart MCP Server 
                                | 
                                +----> search_product ----> OAUTH2 ----> Inventory API 
                                | 
                                +----> submit_backorder ----> OUATH2 ----> Backorder API


# Request & Response

```json

#product request

{
  "jsonrpc": "2.0",
  "id": 101,
  "method": "tools/call",
  "params": {
    "name": "search_product",
    "arguments": {
      "product": "MacAir",
      "quantity": 1
    }
  }
}

#Product response

{
  "jsonrpc": "2.0",
  "id": 101,
  "result": {
    "content": [
      {
        "type": "text",
        "text": "{\"product\":\"MacAir\",\"available\":false,\"alternatives\":[{\"product\":\"MacBook\",\"availableQuantity\":12}]}"
      }
    ]
  }
}
```


OOS event should look like

```json
{
  "specversion": "1.0",
  "eventHeaders": {
  "type": "OOS",
  "source": "backorder-service",
  "eventGuid": "eventGuid",
  "eventDateTime": "DateTime"
  },
  "data": {
    "orderId": "ORD-9981",
    "customerId": "CUST-8891",
    "product": "MacBook",
    "requestedQuantity": 1,
    "eventContext": {
    }
  }
}
```