package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "contract_detail")
@IdClass(ContractDetailId.class)
@Setter
@Getter
@NoArgsConstructor
public class ContractDetail {
    @Id
    @ManyToOne(targetEntity = Contract.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "id")
    private Contract contract;
    @Id
    @ManyToOne(targetEntity = SecondaryServices.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "secondary_service_id")
    private SecondaryServices secondaryServices;
    @Column(name = "quantity")
    @Min(value = 0, message = "The quantity of the secondary service must be greater than 0.")
    private Integer quantity;
}
