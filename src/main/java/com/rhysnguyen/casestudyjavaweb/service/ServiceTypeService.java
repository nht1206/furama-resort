package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.entity.ServiceType;

public interface ServiceTypeService {
    List<ServiceType> findAll();
}