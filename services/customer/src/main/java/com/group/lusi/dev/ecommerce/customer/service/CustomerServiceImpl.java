package com.group.lusi.dev.ecommerce.customer.service;

import com.group.lusi.dev.ecommerce.customer.controller.CustomerResponse;
import com.group.lusi.dev.ecommerce.customer.customer.Customer;
import com.group.lusi.dev.ecommerce.customer.dto.CustomerMapper;
import com.group.lusi.dev.ecommerce.customer.dto.CustomerRequest;
import com.group.lusi.dev.ecommerce.customer.exception.CustomerNotFoundException;
import com.group.lusi.dev.ecommerce.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository
                .save(customerMapper.toCustomer(request));

        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(()-> new CustomerNotFoundException(String.format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())));

        mergerCustomer(customer, request);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    @Override
    public Boolean existById(String id) {
        return customerRepository.findById(id)
                .isPresent();
    }

    @Override
    public CustomerResponse findById(String id) {
        return customerRepository.findById(id)
                .map(customerMapper::fromCustomer)
                .orElseThrow(()-> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID:: %s", id)
                ));
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if(StringUtils.isNotBlank(request.lastName())){
            customer.setFirstName(request.lastName());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setFirstName(request.email());
        }
        if(request.address() != null){
            customer.setAddress(request.address());
        }
    }
}
