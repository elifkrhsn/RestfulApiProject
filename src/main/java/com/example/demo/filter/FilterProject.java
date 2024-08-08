package com.example.demo.filter;

public class FilterProject {
    private String projectName;
    private String projectType;
    private String department;
    private String vpnUsername;
    private String vpnPassword;
    private String environmentInfo;

    // Constructor
    public FilterProject() {}

    // Getters and Setters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVpnUsername() {
        return vpnUsername;
    }

    public void setVpnUsername(String vpnUsername) {
        this.vpnUsername = vpnUsername;
    }

    public String getVpnPassword() {
        return vpnPassword;
    }

    public void setVpnPassword(String vpnPassword) {
        this.vpnPassword = vpnPassword;
    }

    public String getEnvironmentInfo() {
        return environmentInfo;
    }

    public void setEnvironmentInfo(String environmentInfo) {
        this.environmentInfo = environmentInfo;
    }
}
