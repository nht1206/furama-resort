package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(String id);
    void save(Customer customer);
    void delete(String id);
}