package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OtherInformationDTO {

    private Long id;
    private String fullAddress;
    private String bankName;
    private String iban;
    private String emergencyContactName;
    private String emergencyContactPhone;

}
