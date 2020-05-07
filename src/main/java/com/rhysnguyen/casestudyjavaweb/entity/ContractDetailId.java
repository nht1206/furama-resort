package com.rhysnguyen.casestudyjavaweb.entity;

import java.io.Serializable;


public class ContractDetailId implements Serializable {
    private Contract contract;
    private SecondaryServices secondaryServices;

    public ContractDetailId(Contract contract, SecondaryServices secondaryServices) {
        this.contract = contract;
        this.secondaryServices = secondaryServices;
    }
}
