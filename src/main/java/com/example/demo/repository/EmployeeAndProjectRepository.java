package com.example.demo.repository;

import com.example.demo.model.EmployeeAndProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeAndProjectRepository extends JpaRepository<EmployeeAndProject, Long>{
}
