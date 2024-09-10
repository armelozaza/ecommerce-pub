package com.group.lusi.dev.ecommerce.order.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
