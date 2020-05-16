package com.rhysnguyen.casestudyjavaweb.service;


import com.rhysnguyen.casestudyjavaweb.entity.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Long id);
    void save(Contract contract);
    void remove(Long id);
    void remove(Contract contract);
}