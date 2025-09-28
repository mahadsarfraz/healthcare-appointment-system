package com.spring.Healthcare.repository;

import com.spring.Healthcare.model.Doctor;
import com.spring.Healthcare.model.MedicalRecord;
import com.spring.Healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatient(Patient patient);
    List<MedicalRecord> findByDoctor(Doctor doctor);
    List<MedicalRecord> findByPatientAndRecordDateBetween(Patient patient, LocalDateTime start, LocalDateTime end);
}
