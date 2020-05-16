package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.dao.ServiceRepository;
import com.rhysnguyen.casestudyjavaweb.entity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;

    /**
     * @param serviceRepository the serviceRepository to set
     */
    @Autowired
    public void setServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.getOne(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void remove(Service service) {
        serviceRepository.delete(service);
    }
    
}