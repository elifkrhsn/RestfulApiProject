package com.example.demo.projection;

import java.time.LocalDate;

public interface EmployeeEmailProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getLevel();
    String getPhoneNumber();
    LocalDate getBirthDate();
    String getTeam();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getMilitaryStatus();
    String getMaritalStatus();
    String getEmergencyContactName();
    String getEmergencyContactPhone();
    String getProjectName();
    String getProjectType();
    String getDepartment();

}
