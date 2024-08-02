package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "other_information")
@Getter
@Setter
public class OtherInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_address", nullable = false)
    private String fullAddress;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "emergency_contact_name", nullable = false)
    private String emergencyContactName;

    @Column(name = "emergency_contact_phone", nullable = false)
    private String emergencyContactPhone;

    // link back to an employee
    @OneToOne(mappedBy = "otherInformation")
    private Employee employee;



}
