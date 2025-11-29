package com.spring.healthcare.model;

import com.spring.healthcare.data.Doctor;
import com.spring.healthcare.enums.Userenum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorRequest {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Specialization cannot be blank")
    private String specialization;

    @NotBlank(message = "License number cannot be blank")
    private String licenseNumber;

    private Integer yearsOfExperience;

    private String qualification;

    private Double consultationFee;

}
