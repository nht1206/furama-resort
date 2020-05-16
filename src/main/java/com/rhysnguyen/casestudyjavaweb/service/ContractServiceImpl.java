package com.rhysnguyen.casestudyjavaweb.service;


import com.rhysnguyen.casestudyjavaweb.dao.ContractRepository;
import com.rhysnguyen.casestudyjavaweb.entity.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;

    @Autowired
    public void contractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.getOne(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void remove(Contract contract) {
        contractRepository.delete(contract);
    }
    
}