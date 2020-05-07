package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "hop_dong")
@Setter
@Getter
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "ended_on")
    private Date endedOn;
    @Column(name = "deposit")
    private Double deposit;
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToOne(targetEntity = Customer.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(targetEntity = Service.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne(targetEntity = Employee.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(targetEntity = ContractDetail.class,
            mappedBy = "contract",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private Set<ContractDetail> contractDetails;
}
