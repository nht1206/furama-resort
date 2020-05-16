package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rhysnguyen.casestudyjavaweb.validation.IdentityCard;
import com.rhysnguyen.casestudyjavaweb.validation.PhoneNumber;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "{Employee.id.NotNull}")
    private Long id;

    @Column(name = "full_name")
    @NotBlank(message = "{Employee.fullName.NotBlank}")
    private String fullName;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{Employee.dateOfBirth.NotNull}")
    private Date dateOfBirth;

    @Column(name = "identity_card_number")
    @IdentityCard(message = "{Employee.identityCardNumber.Valid}")
    @NotBlank(message = "{Employee.identityCardNumber.NotBlank}")
    private String identityCardNumber;

    @Column(name = "contact_number")
    @PhoneNumber
    @NotBlank(message = "{Employee.contactNumber.NotBlank}")
    private String contactNumber;

    @Email(message = "{Employee.email.Valid}")
    @Column(name = "email")
    @NotBlank(message = "{Employee.email.NotBlank}")
    private String email;

    @Column(name = "address")
    @NotBlank(message = "{Employee.address.NotBlank}")
    private String address;

    @Min(value = 0 , message = "Wages should be greater than 0.")
    @Column(name = "wages")
    @NotNull(message = "{Employee.wages.NotNull}")
    private Double wages;
    @ManyToOne(targetEntity = Degree.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne(targetEntity = Department.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(targetEntity = Position.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "position_id")
    private Position position;
    @OneToMany(targetEntity = Contract.class,
            mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Contract> contracts;
}
