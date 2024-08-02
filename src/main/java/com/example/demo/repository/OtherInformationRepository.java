package com.example.demo.repository;

import com.example.demo.model.OtherInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OtherInformationRepository extends JpaRepository<OtherInformation, Long> {
    //custom queries
}
