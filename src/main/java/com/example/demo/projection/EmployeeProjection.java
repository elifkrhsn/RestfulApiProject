package com.example.demo.projection;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.model.*;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getLevel();
    String getPhoneNumber();
    String getEmail();
    LocalDate getBirthDate();
    String getWorkMode();
    String getContractType();
    String getTeam();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getIdentityNumber();
    String getMilitaryStatus();
    String getGender();
    String getMaritalStatus();
    String getFullAddress();
    String getBankName();
    String getIban();
    String getEmergencyContactName();
    String getEmergencyContactPhone();
    String getProjectName();
    String getProjectType();
    String getDepartment();
    String getVpnUsername();
    String getVpnPassword();
    String getEnvironmentInfo();


}
