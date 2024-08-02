package com.example.demo.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProjectDTO {

    private Long id;
    private String projectName;
    private String projectType;
    private String department;
    private String vpnUsername;
    private String vpnPassword;
    private String environmentInfo;

}
