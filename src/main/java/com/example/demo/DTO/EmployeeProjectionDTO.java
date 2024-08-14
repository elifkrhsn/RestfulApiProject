package com.example.demo.DTO;


import com.example.demo.model.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectionDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Level level;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private WorkMode workMode;
    private ContractType contractType;
    private String team;
    private LocalDate startDate;
    private LocalDate endDate;
    private PersonalInformation personalInformation;
    private OtherInformation otherInformation;
    private List<ProjectDTO> project; //ProjectDTO mu Project mi type
}
