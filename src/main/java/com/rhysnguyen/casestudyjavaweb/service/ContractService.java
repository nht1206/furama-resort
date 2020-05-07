package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.entity.Contract;

public interface ContractService {
    List<Contract> findAll();
    Contract findById(Long id);
    void save(Contract contract);
    void remove(Long id);
    void remove(Contract contract);
}