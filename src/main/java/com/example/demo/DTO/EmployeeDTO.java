package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String level;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private String workMode;
    private String contractType;
    private String team;
    private LocalDate startDate;
    private LocalDate endDate;
    private PersonalInformationDTO personalInformation;
    private OtherInformationDTO otherInformation;
    private List<ProjectDTO> project;


}
