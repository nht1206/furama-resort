package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.dao.CustomerTypeRepository;
import com.rhysnguyen.casestudyjavaweb.entity.CustomerType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    private CustomerTypeRepository customerTypeRepository;

    /**
     * @param customerTypeRepository the customerTypeRepository to set
     */
    @Autowired
    public void setCustomerTypeRepository(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.getOne(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Long id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public void remove(CustomerType customerType) {
        customerTypeRepository.delete(customerType);
    }
    
}