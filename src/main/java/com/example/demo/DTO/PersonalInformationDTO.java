package com.example.demo.DTO;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PersonalInformationDTO {

    private Long id;
    private LocalDate birthdate;
    private String identityNumber;
    private String militaryStatus;
    private String gender;
    private String maritalStatus;

}

