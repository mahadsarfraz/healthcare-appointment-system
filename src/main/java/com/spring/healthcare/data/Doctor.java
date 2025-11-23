package com.spring.healthcare.data;

import com.spring.healthcare.enums.Userenum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Doctor extends User {

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "consultation_fee")
    private Double consultationFee;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    public Doctor(Integer id, String firstName, String lastName, String email, String password,
                  String phoneNumber, Userenum.UserRole role, String specialization,
                  String licenseNumber) {
        super(id, firstName, lastName, email, password, phoneNumber, role);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.isAvailable = true;
    }
}