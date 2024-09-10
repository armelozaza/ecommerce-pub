package com.group.lusi.dev.ecommerce.order.payment;

import com.group.lusi.dev.ecommerce.order.customer.CustomerResponse;
import com.group.lusi.dev.ecommerce.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
