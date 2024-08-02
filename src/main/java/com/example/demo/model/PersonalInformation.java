package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "personal_information")
@Getter
@Setter
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "military_status", nullable = false)
    private MilitaryStatus militaryStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", nullable = false)
    private MaritalStatus maritalStatus;

    //link back to an employee
    @OneToOne(mappedBy = "personalInformation")
    private Employee employee;
}
