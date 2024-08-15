package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeEmailProjection;
import com.example.demo.projection.EmployeeFullNameProjection;
import com.example.demo.projection.EmployeePhoneNumberProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    @Query("SELECT COUNT(e) > 0 FROM Employee e WHERE e.otherInformation.iban = :iban")
    boolean existsByIban(@Param("iban") String iban);

    @Query("SELECT COUNT(e) > 0 FROM Employee e WHERE e.personalInformation.identityNumber = :identityNumber")
    boolean existsByIdentityNumber(@Param("identityNumber") String identityNNumber);

    //custom queries for projection

    //Query for projection by email
    @Query("SELECT e.id as id, e.firstName as firstName, e.lastName as lastName, e.level as level, " +
            "e.phoneNumber as phoneNumber, e.birthDate as birthDate, " +
            "e.team as team, e.startDate as startDate, e.endDate as endDate, " +
            "p.identityNumber as identityNumber, p.militaryStatus as militaryStatus, " +
            "p.maritalStatus as maritalStatus, " +
            "o.emergencyContactName as emergencyContactName, o.emergencyContactPhone as emergencyContactPhone, " +
            "proj.projectName as projectName, proj.projectType as projectType, proj.department as department " +
            "FROM Employee e " +
            "LEFT JOIN e.personalInformation p " +
            "LEFT JOIN e.otherInformation o " +
            "LEFT JOIN e.project proj " +
            "WHERE e.email = :email")
    EmployeeEmailProjection findEmployeeProjectionByEmail(@Param("email") String email);



    //Query for projection by phone number
    @Query("SELECT e.id as id, e.firstName as firstName, e.lastName as lastName, " +
            "e.email as email, e.workMode as workMode, " +
            "e.contractType as contractType, " +
            "p.identityNumber as identityNumber, p.gender as gender, " +
            "o.fullAddress as fullAddress, o.bankName as bankName, " +
            "o.iban as iban " +
            "FROM Employee e " +
            "LEFT JOIN e.personalInformation p " +
            "LEFT JOIN e.otherInformation o " +
            "WHERE e.phoneNumber = :phoneNumber")
    EmployeePhoneNumberProjection findEmployeeProjectionByPhoneNumber(@Param("phoneNumber") String phoneNumber);


    //Query for projection by full name
    @Query("SELECT e.id as id, CONCAT(e.firstName, ' ', e.lastName) as fullName, e.level as level, " +
            "e.phoneNumber as phoneNumber, e.email as email, e.birthDate as birthDate, e.workMode as workMode, " +
            "e.contractType as contractType, e.team as team, e.startDate as startDate, e.endDate as endDate, " +
            "p.identityNumber as identityNumber, p.militaryStatus as militaryStatus, p.gender as gender, " +
            "p.maritalStatus as maritalStatus, o.fullAddress as fullAddress, o.bankName as bankName, " +
            "o.iban as iban, o.emergencyContactName as emergencyContactName, o.emergencyContactPhone as emergencyContactPhone, " +
            "proj.projectName as projectName, proj.projectType as projectType, proj.department as department, " +
            "proj.vpnUsername as vpnUsername, proj.vpnPassword as vpnPassword, proj.environmentInfo as environmentInfo " +
            "FROM Employee e " +
            "LEFT JOIN e.personalInformation p " +
            "LEFT JOIN e.otherInformation o " +
            "LEFT JOIN e.project proj " +
            "WHERE CONCAT(e.firstName, ' ', e.lastName) = :fullName")
    EmployeeFullNameProjection findEmployeeProjectionByFullName(@Param("fullName") String fullName);



}