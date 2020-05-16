package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rhysnguyen.casestudyjavaweb.validation.ResortCode;

import java.util.Set;

@Entity
@Table(name = "service")
@Setter
@Getter
@NoArgsConstructor
public class Service {
    @Id
    @Column(name = "service_id")
    @ResortCode(regex = "^DV-[0-9]{4}$", message = "{service.id.invalid}")
    private String serviceId;
    @Column(name = "name")
    @NotBlank(message = "Name is required.")
    private String name;
    @Column(name = "area")
    @Min(value = 0, message = "{service.area.positive}")
    @NotNull(message = "Area is required.")
    private Float area;
    @Column(name = "rent_fee")
    @Min(value = 0, message = "The rent fee should be greater than 0.")
    @NotNull(message = "Rent fee is required.")
    private Double rentFee;
    @Column(name = "number_of_floors")
    @Min(value = 1, message = "The number of floors should be greater than 0.")
    @NotNull(message = "Number of floors is required.")
    private Integer numberOfFloors;
    @Column(name = "max_number_of_people")
    @Min(value = 1, message = "The max number of people should be greater than 0.")
    @NotNull(message = "Max number of people is required.")
    private Integer maxNumberOfPeople;
    @Column(name = "status")
    @NotBlank(message = "Name is required.")
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
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "service",
            cascade = CascadeType.ALL
    )
    private Set<Contract> contracts;
}
