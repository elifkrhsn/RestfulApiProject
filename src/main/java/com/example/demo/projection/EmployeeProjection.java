package com.example.demo.projection;

import com.example.demo.model.Level;
import com.example.demo.model.WorkMode;

import java.time.LocalDate;

public interface EmployeeProjection {

    String getFirstName();
    String getLastName();
    String getEmail();
    LocalDate getBirthDate();
    Level getLevel();
    WorkMode getWorkMode();

}
