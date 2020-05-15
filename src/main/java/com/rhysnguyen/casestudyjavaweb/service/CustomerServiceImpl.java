package com.rhysnguyen.casestudyjavaweb.service;


import com.rhysnguyen.casestudyjavaweb.dao.CustomerRepository;
import com.rhysnguyen.casestudyjavaweb.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    /**
     * @param customerRepository the customerRepository to set
     */
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
    
}