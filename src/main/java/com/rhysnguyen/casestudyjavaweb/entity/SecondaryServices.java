package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

import java.util.Set;

@Entity
@Table(name = "secondary_service")
@Setter
@Getter
@NoArgsConstructor
public class SecondaryServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    @Min(value = 0, message = "The price must be greater than 0.")
    private Double price;
    @Column(name = "unit")
    private int unit;
    @OneToMany(targetEntity = ContractDetail.class,
            mappedBy = "secondaryServices",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private Set<ContractDetail> contractDetails;
}
