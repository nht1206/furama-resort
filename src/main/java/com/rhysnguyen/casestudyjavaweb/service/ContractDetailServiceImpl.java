package com.rhysnguyen.casestudyjavaweb.service;

import java.util.List;

import com.rhysnguyen.casestudyjavaweb.dao.ContractDetailRepository;
import com.rhysnguyen.casestudyjavaweb.entity.ContractDetail;

import org.springframework.beans.factory.annotation.Autowired;

public class ContractDetailServiceImpl implements ContractDetailService {

    private ContractDetailRepository contractDetailRepository;

    /**
     * @param contractDetailRepository the contractDetailRepository to set
     */
    @Autowired
    public void setContractDetailRepository(ContractDetailRepository contractDetailRepository) {
        this.contractDetailRepository = contractDetailRepository;
    }    

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.getOne(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public void remove(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
    
}