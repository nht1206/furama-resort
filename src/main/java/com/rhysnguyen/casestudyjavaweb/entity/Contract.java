package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
@Setter
@Getter
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_on")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Column(name = "ended_on")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endedOn;
    @Column(name = "deposit")
    @Min(value = 0, message = "Deposit amount must be greater than 0.")
    private Double deposit;
    @Column(name = "total_price")
    @Min(value = 0, message = "The total price should be greater than 0.")
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
