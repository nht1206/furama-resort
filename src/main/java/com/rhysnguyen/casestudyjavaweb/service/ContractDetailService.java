package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.entity.ContractDetail;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    ContractDetail findById(Long id);
    void save(ContractDetail contractDetail);
    void remove(Long id);
    void remove(ContractDetail contractDetail);
}