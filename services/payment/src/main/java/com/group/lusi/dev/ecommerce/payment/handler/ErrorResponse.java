package com.group.lusi.dev.ecommerce.payment.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
