package com.example.demo.mapper;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.OtherInformationDTO;
import com.example.demo.DTO.PersonalInformationDTO;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.DTO.EmployeeProjectionDTO;
import com.example.demo.model.ContractType;
import com.example.demo.model.Employee;
import com.example.demo.model.Gender;
import com.example.demo.model.Level;
import com.example.demo.model.MaritalStatus;
import com.example.demo.model.MilitaryStatus;
import com.example.demo.model.OtherInformation;
import com.example.demo.model.PersonalInformation;
import com.example.demo.model.Project;
import com.example.demo.model.WorkMode;
import com.example.demo.projection.EmployeeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;

@Component
public class EmployeeMapper {

    @Autowired
    private ProjectMapper projectMapper;

    public Employee toEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( dto.getId() );
        employee.setFirstName( dto.getFirstName() );
        employee.setLastName( dto.getLastName() );
        if ( dto.getLevel() != null ) {
            employee.setLevel( Enum.valueOf( Level.class, dto.getLevel() ) );
        }
        employee.setPhoneNumber( dto.getPhoneNumber() );
        employee.setEmail( dto.getEmail() );
        employee.setBirthDate( dto.getBirthDate() );
        if ( dto.getWorkMode() != null ) {
            employee.setWorkMode( Enum.valueOf( WorkMode.class, dto.getWorkMode() ) );
        }
        if ( dto.getContractType() != null ) {
            employee.setContractType( Enum.valueOf( ContractType.class, dto.getContractType() ) );
        }
        employee.setTeam( dto.getTeam() );
        employee.setStartDate( dto.getStartDate() );
        employee.setEndDate( dto.getEndDate() );
        employee.setPersonalInformation( personalInformationDTOToPersonalInformation( dto.getPersonalInformation() ) );
        employee.setOtherInformation( otherInformationDTOToOtherInformation( dto.getOtherInformation() ) );
        if(!CollectionUtils.isEmpty(dto.getProject())){
            employee.setProject(dto.getProject().stream().map(this::projectDTOToProject).collect(Collectors.toList()));
        }

        return employee;
    }

    public EmployeeDTO toDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setFirstName( employee.getFirstName() );
        employeeDTO.setLastName( employee.getLastName() );
        if ( employee.getLevel() != null ) {
            employeeDTO.setLevel( employee.getLevel().name() );
        }
        employeeDTO.setPhoneNumber( employee.getPhoneNumber() );
        employeeDTO.setEmail( employee.getEmail() );
        employeeDTO.setBirthDate( employee.getBirthDate() );
        if ( employee.getWorkMode() != null ) {
            employeeDTO.setWorkMode( employee.getWorkMode().name() );
        }
        if ( employee.getContractType() != null ) {
            employeeDTO.setContractType( employee.getContractType().name() );
        }
        employeeDTO.setTeam( employee.getTeam() );
        employeeDTO.setStartDate( employee.getStartDate() );
        employeeDTO.setEndDate( employee.getEndDate() );
        employeeDTO.setPersonalInformation( personalInformationToPersonalInformationDTO( employee.getPersonalInformation() ) );
        employeeDTO.setOtherInformation( otherInformationToOtherInformationDTO( employee.getOtherInformation() ) );
        if(!CollectionUtils.isEmpty(employee.getProject())){
            employeeDTO.setProject(employee.getProject().stream().map(this::projectToProjectDTO).collect(Collectors.toList()));

        }

        return employeeDTO;
    }

    protected PersonalInformation personalInformationDTOToPersonalInformation(PersonalInformationDTO personalInformationDTO) {
        if ( personalInformationDTO == null ) {
            return null;
        }

        PersonalInformation personalInformation = new PersonalInformation();

        personalInformation.setId( personalInformationDTO.getId() );
        personalInformation.setBirthdate( personalInformationDTO.getBirthdate() );
        personalInformation.setIdentityNumber( personalInformationDTO.getIdentityNumber() );
        if ( personalInformationDTO.getMilitaryStatus() != null ) {
            personalInformation.setMilitaryStatus( Enum.valueOf( MilitaryStatus.class, personalInformationDTO.getMilitaryStatus() ) );
        }
        if ( personalInformationDTO.getGender() != null ) {
            personalInformation.setGender( Enum.valueOf( Gender.class, personalInformationDTO.getGender() ) );
        }
        if ( personalInformationDTO.getMaritalStatus() != null ) {
            personalInformation.setMaritalStatus( Enum.valueOf( MaritalStatus.class, personalInformationDTO.getMaritalStatus() ) );
        }

        return personalInformation;
    }

    protected OtherInformation otherInformationDTOToOtherInformation(OtherInformationDTO otherInformationDTO) {
        if ( otherInformationDTO == null ) {
            return null;
        }

        OtherInformation otherInformation = new OtherInformation();

        otherInformation.setId( otherInformationDTO.getId() );
        otherInformation.setFullAddress( otherInformationDTO.getFullAddress() );
        otherInformation.setBankName( otherInformationDTO.getBankName() );
        otherInformation.setIban( otherInformationDTO.getIban() );
        otherInformation.setEmergencyContactName( otherInformationDTO.getEmergencyContactName() );
        otherInformation.setEmergencyContactPhone( otherInformationDTO.getEmergencyContactPhone() );

        return otherInformation;
    }

    protected Project projectDTOToProject(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDTO.getId() );
        project.setProjectName( projectDTO.getProjectName() );
        project.setProjectType( projectDTO.getProjectType() );
        project.setDepartment( projectDTO.getDepartment() );
        project.setVpnUsername( projectDTO.getVpnUsername() );
        project.setVpnPassword( projectDTO.getVpnPassword() );
        project.setEnvironmentInfo( projectDTO.getEnvironmentInfo() );

        return project;
    }

    protected List<Project> projectDTOListToProjectList(List<ProjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Project> list1 = new ArrayList<Project>( list.size() );
        for ( ProjectDTO projectDTO : list ) {
            list1.add( projectDTOToProject( projectDTO ) );
        }

        return list1;
    }

    protected PersonalInformationDTO personalInformationToPersonalInformationDTO(PersonalInformation personalInformation) {
        if ( personalInformation == null ) {
            return null;
        }

        PersonalInformationDTO personalInformationDTO = new PersonalInformationDTO();

        personalInformationDTO.setId( personalInformation.getId() );
        personalInformationDTO.setBirthdate( personalInformation.getBirthdate() );
        personalInformationDTO.setIdentityNumber( personalInformation.getIdentityNumber() );
        if ( personalInformation.getMilitaryStatus() != null ) {
            personalInformationDTO.setMilitaryStatus( personalInformation.getMilitaryStatus().name() );
        }
        if ( personalInformation.getGender() != null ) {
            personalInformationDTO.setGender( personalInformation.getGender().name() );
        }
        if ( personalInformation.getMaritalStatus() != null ) {
            personalInformationDTO.setMaritalStatus( personalInformation.getMaritalStatus().name() );
        }

        return personalInformationDTO;
    }

    protected OtherInformationDTO otherInformationToOtherInformationDTO(OtherInformation otherInformation) {
        if ( otherInformation == null ) {
            return null;
        }

        OtherInformationDTO otherInformationDTO = new OtherInformationDTO();

        otherInformationDTO.setId( otherInformation.getId() );
        otherInformationDTO.setFullAddress( otherInformation.getFullAddress() );
        otherInformationDTO.setBankName( otherInformation.getBankName() );
        otherInformationDTO.setIban( otherInformation.getIban() );
        otherInformationDTO.setEmergencyContactName( otherInformation.getEmergencyContactName() );
        otherInformationDTO.setEmergencyContactPhone( otherInformation.getEmergencyContactPhone() );

        return otherInformationDTO;
    }

    protected ProjectDTO projectToProjectDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId( project.getId() );
        projectDTO.setProjectName( project.getProjectName() );
        projectDTO.setProjectType( project.getProjectType() );
        projectDTO.setDepartment( project.getDepartment() );
        projectDTO.setVpnUsername( project.getVpnUsername() );
        projectDTO.setVpnPassword( project.getVpnPassword() );
        projectDTO.setEnvironmentInfo( project.getEnvironmentInfo() );

        return projectDTO;
    }

    protected List<ProjectDTO> projectListToProjectDTOList(List<Project> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDTO> list1 = new ArrayList<ProjectDTO>( list.size() );
        for ( Project project : list ) {
            list1.add( projectToProjectDTO( project ) );
        }

        return list1;
    }

    public EmployeeProjectionDTO projectionToEmployeeProjectionDTO(EmployeeProjection projection) {
        EmployeeProjectionDTO employeeProjectionDTO = new EmployeeProjectionDTO();
        employeeProjectionDTO.setId(projection.getId());
        employeeProjectionDTO.setFirstName(projection.getFirstName());
        employeeProjectionDTO.setLastName(projection.getLastName());
        employeeProjectionDTO.setLevel(projection.getLevel());
        employeeProjectionDTO.setPhoneNumber(projection.getPhoneNumber());
        employeeProjectionDTO.setEmail(projection.getEmail());
        employeeProjectionDTO.setBirthDate(projection.getBirthDate());
        employeeProjectionDTO.setWorkMode(projection.getWorkMode());
        employeeProjectionDTO.setContractType(projection.getContractType());
        employeeProjectionDTO.setTeam(projection.getTeam());
        employeeProjectionDTO.setStartDate(projection.getStartDate());
        employeeProjectionDTO.setEndDate(projection.getEndDate());
        employeeProjectionDTO.setPersonalInformation(projection.getPersonalInformation());
        employeeProjectionDTO.setOtherInformation(projection.getOtherInformation());
        employeeProjectionDTO.setProject(projection.getProject());

        return employeeProjectionDTO;
    }


}
