package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;


@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_type", nullable = false)
    private String projectType;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "vpn_username")
    private String vpnUsername;

    @Column(name = "vpn_password")
    private String vpnPassword;

    @Column(name = "environment_info")
    private String environmentInfo;

    // Relationship with employees is one to many because one project can have many employees
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;

}
