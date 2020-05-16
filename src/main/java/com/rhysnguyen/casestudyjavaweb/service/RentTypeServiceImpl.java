package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.dao.RentTypeRepository;
import com.rhysnguyen.casestudyjavaweb.entity.RentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    RentTypeRepository rentTypeRepository;

    /**
     * @param rentTypeRepository the rentTypeRepository to set
     */
    @Autowired
    public void setRentTypeRepository(RentTypeRepository rentTypeRepository) {
        this.rentTypeRepository = rentTypeRepository;
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
    
}