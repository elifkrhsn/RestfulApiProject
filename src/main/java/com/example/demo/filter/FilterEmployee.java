package com.example.demo.filter;


import com.example.demo.model.Level;
import com.example.demo.model.WorkMode;
import com.example.demo.model.ContractType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter

public class FilterEmployee {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private Level level;
    private WorkMode workMode;
    private ContractType contractType;
    private String team;
    private LocalDate startDate;
    private LocalDate endDate;
}