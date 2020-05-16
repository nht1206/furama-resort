package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.dao.ServiceTypeRepository;
import com.rhysnguyen.casestudyjavaweb.entity.ServiceType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
    
}