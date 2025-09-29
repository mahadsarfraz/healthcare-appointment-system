package com.spring.Healthcare.data;

import com.spring.Healthcare.enums.Userenum.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "doctors")
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

    private String specialization;

    @Column(name = "license_number", unique = true)
    private String licenseNumber;

    @Column(name = "consultation_fee")
    private Double consultationFee;

    private String qualifications;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    // Can store availability as JSON or another format, or create a separate entity
    private String availability;

    public Doctor(String name, String email, String password, String phoneNumber,
                 String specialization, String licenseNumber, Double consultationFee) {
        super(null, name, email, password, phoneNumber, UserRole.DOCTOR);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.consultationFee = consultationFee;
    }
}
