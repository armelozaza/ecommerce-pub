package com.group.lusi.dev.ecommerce.customer.service;

import com.group.lusi.dev.ecommerce.customer.controller.CustomerResponse;
import com.group.lusi.dev.ecommerce.customer.dto.CustomerRequest;
import org.springframework.http.ProblemDetail;

import java.util.List;

public interface CustomerService {

    public String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existById(String id);

    CustomerResponse findById(String id);

    void deleteById(String id);
}
