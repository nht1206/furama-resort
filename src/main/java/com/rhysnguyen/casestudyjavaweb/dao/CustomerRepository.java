package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    
}