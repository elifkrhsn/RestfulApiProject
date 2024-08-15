package com.example.demo.repository;

import com.example.demo.model.Project;
import com.example.demo.projection.ProjectProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

    //custom query for projection by project name
    @Query("SELECT p.id as id, p.projectName as projectName, p.projectType as projectType, " +
            "p.department as department, p.vpnUsername as vpnUsername, p.environmentInfo as environmentInfo " +
            "FROM Project p WHERE p.projectName = :projectName")
    ProjectProjection findProjectProjectionByProjectName(@Param("projectName") String projectName);


}
