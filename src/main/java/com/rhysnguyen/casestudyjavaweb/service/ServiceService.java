package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.entity.Service;

public interface ServiceService {
    List<Service> findAll();
    Service findById(Long id);
    void save(Service service);
    void remove(Long id);
    void remove(Service service);
}