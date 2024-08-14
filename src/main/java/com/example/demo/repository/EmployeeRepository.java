package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.DTO.EmployeeProjectionDTO;
import com.example.demo.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {


    @Query("SELECT e FROM Employee e WHERE e.id = :id AND e.otherInformation.id = :id AND e.personalInformation.id= :id")
    EmployeeProjection findEmployeeProjectionById(Long id);

/*

    @Query("SELECT e FROM Employee e WHERE e.email = :email AND e.otherInformation.id = :id AND e.personalInformation.id= :id")
    EmployeeProjection findEmployeeProjectionByEmail(String email);
*/

    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findAllEmployees();

/*
    @Query("SELECT new com.example.demo.dto.EmployeeProjectionDTO(e.id, e.firstName, e.lastName, e.level, e.phoneNumber, e.email, e.birthDate, e.workMode, e.contractType, e.team, e.startDate, e.endDate, e.personalInformation, e.otherInformation, e.project) FROM Employee e WHERE e.id = :id")
    List<EmployeeProjectionDTO> findByLastName(@Param("lastName") String lastName);

 */
/*

    @Query("SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")
    List<Employee> findEmployeesByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findEmployeeByEmail(@Param("email") String email);

*/

}