package com.example.demo.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.util.List;

@Getter
@Setter
@Data
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Project name is required.")
    private String projectName;

    @NotBlank(message = "Project type is required.")
    private String projectType;

    @NotBlank(message = "Department is required.")
    private String department;

    private String vpnUsername;
    private String vpnPassword;
    private String environmentInfo;
    private List<Long> employeeIds;

}
