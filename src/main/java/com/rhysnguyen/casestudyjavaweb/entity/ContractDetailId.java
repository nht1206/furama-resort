package com.rhysnguyen.casestudyjavaweb.entity;

import java.io.Serializable;

public class ContractDetailId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6658014422223855991L;
    
    private final Contract contract;
    private final SecondaryServices secondaryServices;

    public ContractDetailId(final Contract contract, final SecondaryServices secondaryServices) {
        this.contract = contract;
        this.secondaryServices = secondaryServices;
    }

    public Contract getContract() {
        return contract;
    }

    public SecondaryServices getSecondaryServices() {
        return secondaryServices;
    }
}
