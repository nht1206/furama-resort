package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.dao.ServiceRepository;
import com.rhysnguyen.casestudyjavaweb.entity.Service;

import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.getOne(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void remove(Service service) {
        serviceRepository.delete(service);
    }
    
}