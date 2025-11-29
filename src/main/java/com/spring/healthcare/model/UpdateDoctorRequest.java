package com.spring.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;
    private Integer yearsOfExperience;
    private String qualification;
}