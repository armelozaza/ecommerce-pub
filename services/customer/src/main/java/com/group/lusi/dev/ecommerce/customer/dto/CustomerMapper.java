package com.group.lusi.dev.ecommerce.customer.dto;

import com.group.lusi.dev.ecommerce.customer.controller.CustomerResponse;
import com.group.lusi.dev.ecommerce.customer.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request){
        if (request == null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        if (customer == null){
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
