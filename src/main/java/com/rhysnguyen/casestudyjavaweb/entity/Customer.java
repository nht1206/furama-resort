package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rhysnguyen.casestudyjavaweb.validation.IdentityCard;
import com.rhysnguyen.casestudyjavaweb.validation.PhoneNumber;
import com.rhysnguyen.casestudyjavaweb.validation.ResortCode;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    @ResortCode(regex = "^KH-[0-9]{4}$", 
        message = "{Customer.id.ResortCode}"
        )
    @NotNull(message = "{Customer.id.NotNull}")
    private String customerId;
    @Column(name = "full_name")
    @NotBlank(message = "{Customer.fullName.NotBlank}")
    private String fullName;
    @Column(name = "date_of_birth")
    @NotNull(message = "{Customer.dateOfBirth.NotNull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "gender")
    @NotBlank(message = "{Customer.gender.NotBlank}")
    private String gender;
    @Column(name = "identity_card_number")
    @IdentityCard
    @NotBlank(message = "{Customer.identityCardNumber.NotBlank}")
    private String identityCardNumber;
    @Column(name = "contact_number")
    @NotBlank(message = "{Customer.contactNumber.NotBlank}")
    @PhoneNumber
    private String contactNumber;
    @Column(name = "email")
    @Email(message = "{Customer.email.Valid}")
    @NotBlank(message = "{Customer.email.NotBlank}")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "{Customer.address.NotBlank}")
    private String address;
    @OneToOne(targetEntity = CustomerType.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;
    @OneToMany(targetEntity = Contract.class,
            mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Contract> contracts;
}
