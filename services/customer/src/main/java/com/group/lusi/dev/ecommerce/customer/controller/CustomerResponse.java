package com.group.lusi.dev.ecommerce.customer.controller;

import com.group.lusi.dev.ecommerce.customer.customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

}
