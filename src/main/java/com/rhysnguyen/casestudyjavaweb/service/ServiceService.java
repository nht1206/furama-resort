package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);
    Service findById(String id);
    void save(Service service);
    void remove(String id);
    void remove(Service service);
}