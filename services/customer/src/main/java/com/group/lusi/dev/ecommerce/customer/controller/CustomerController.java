package com.group.lusi.dev.ecommerce.customer.controller;


import com.group.lusi.dev.ecommerce.customer.dto.CustomerMapper;
import com.group.lusi.dev.ecommerce.customer.dto.CustomerRequest;
import com.group.lusi.dev.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        customerService.updateCustomer(request);
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existById(
            @PathVariable("customer-id") String id
    ){
        return ResponseEntity.ok(customerService.existById(id));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String id
    ){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("customer-id") String id
    ){
        customerService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
