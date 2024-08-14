package com.example.demo.projection;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.model.*;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    Level getLevel();
    String getPhoneNumber();
    String getEmail();
    LocalDate getBirthDate();
    WorkMode getWorkMode();
    ContractType getContractType();
    String getTeam();
    LocalDate getStartDate();
    LocalDate getEndDate();
    PersonalInformation getPersonalInformation();
    OtherInformation getOtherInformation();
    List<ProjectDTO> getProject();

}
