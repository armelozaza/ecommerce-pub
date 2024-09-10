package com.group.lusi.dev.ecommerce.customer.exception;

import java.util.Map;

public record ErrorResponse
        (Map<String, String> errors)
{

}
