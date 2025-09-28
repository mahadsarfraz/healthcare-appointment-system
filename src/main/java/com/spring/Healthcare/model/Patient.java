package com.spring.Healthcare.model;

import com.spring.Healthcare.enums.Userenum.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "patients")
@DiscriminatorValue("PATIENT")
public class Patient extends User {

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "medical_history", columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    public Patient(String name, String email, String password, String phoneNumber,
                  LocalDate dateOfBirth, String bloodGroup) {
        super(null, name, email, password, phoneNumber, UserRole.PATIENT);
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
    }
}
