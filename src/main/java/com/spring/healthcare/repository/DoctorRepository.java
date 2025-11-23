package com.spring.healthcare.repository;

import com.spring.healthcare.data.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
