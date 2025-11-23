package com.spring.healthcare.repository;

import com.spring.healthcare.data.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
