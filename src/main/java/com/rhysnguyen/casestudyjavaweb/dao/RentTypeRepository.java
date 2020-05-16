package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.RentType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType, Long> {
    
}