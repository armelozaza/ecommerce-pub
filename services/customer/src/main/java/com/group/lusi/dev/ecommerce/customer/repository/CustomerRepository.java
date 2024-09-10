package com.group.lusi.dev.ecommerce.customer.repository;

import com.group.lusi.dev.ecommerce.customer.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
