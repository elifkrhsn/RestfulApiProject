package com.example.demo.projection;

import com.example.demo.model.*;

import java.time.LocalDate;


public interface ProjectProjection {

    Long getId();
    String getProjectName();
    String getProjectType();
    String getDepartment();
    String getVpnUsername();
    String getEnvironmentInfo();

}
