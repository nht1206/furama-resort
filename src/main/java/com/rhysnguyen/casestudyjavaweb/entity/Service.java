package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
@Setter
@Getter
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    private Float area;
    @Column(name = "rent_fee")
    private Double rentFee;
    @Column(name = "number_od_floors")
    private Integer numberOfFloors;
    @Column(name = "max_number_of_people")
    private Integer maxNumberOfPeople;
    @Column(name = "status")
    private String status;
    @ManyToOne(targetEntity = ServiceType.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
    @ManyToOne(targetEntity = RentType.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "service",
            cascade = CascadeType.ALL
    )
    private Set<Contract> contracts;
}
