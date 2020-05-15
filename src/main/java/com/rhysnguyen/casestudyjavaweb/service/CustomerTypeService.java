package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.entity.CustomerType;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    CustomerType findById(Long id);
    void save(CustomerType customerType);
    void remove(Long id);
    void remove(CustomerType customerType);
}