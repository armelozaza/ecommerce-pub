package com.group.lusi.dev.ecommerce.order.kafka;

import com.group.lusi.dev.ecommerce.order.customer.CustomerResponse;
import com.group.lusi.dev.ecommerce.order.order.PaymentMethod;
import com.group.lusi.dev.ecommerce.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
