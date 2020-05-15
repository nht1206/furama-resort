package com.rhysnguyen.casestudyjavaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rhysnguyen.validation.IdentityCard;
import com.rhysnguyen.validation.PhoneNumber;
import com.rhysnguyen.validation.ResortCode;

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
        message = "Customer code should look like - KH-XXXX with X as a number between 0 - 9"
        )
    @NotNull(message = "Customer is required")
    private String customerId;
    @Column(name = "full_name")
    @NotBlank(message = "Fullname is required")
    private String fullName;
    @Column(name = "date_of_birth")
    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "gender")
    @NotBlank(message = "Gender is required")
    private String gender;
    @Column(name = "identity_card_number")
    @IdentityCard
    @NotBlank(message = "Identity card number is required")
    private String identityCardNumber;
    @Column(name = "contact_number")
    @NotBlank(message = "Contact number is required")
    @PhoneNumber
    private String contactNumber;
    @Column(name = "email")
    @Email(message = "Email is not valid.")
    @NotBlank(message = "Email is required")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "Address is required")
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
