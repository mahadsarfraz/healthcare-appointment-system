package com.spring.healthcare.model;

import com.spring.healthcare.data.Doctor;
import com.spring.healthcare.enums.Userenum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Userenum.UserRole role;
    private String specialization;
    private String licenseNumber;
    private Integer yearsOfExperience;
    private String qualification;
    private Double consultationFee;

    public static DoctorResponse mapToDocResponse(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPhoneNumber(),
                doctor.getRole(),
                doctor.getSpecialization(),
                doctor.getLicenseNumber(),
                doctor.getYearsOfExperience(),
                doctor.getQualification(),
                doctor.getConsultationFee()
        );
    }
}
