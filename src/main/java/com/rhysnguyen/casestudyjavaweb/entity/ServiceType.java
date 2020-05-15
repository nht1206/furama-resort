package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
@Setter
@Getter
@NoArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;
    @Column(name = "service_type_name")
    private String name;
}
