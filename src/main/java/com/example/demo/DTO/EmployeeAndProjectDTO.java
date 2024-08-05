package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EmployeeAndProjectDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String projectName;
    private String projectType;
    private String department;

}
