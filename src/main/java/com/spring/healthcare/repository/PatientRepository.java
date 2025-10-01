//package com.spring.Healthcare.repository;
//
//import com.spring.Healthcare.data.Patient;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface PatientRepository extends JpaRepository<Patient, Long> {
//    List<Patient> findByBloodGroup(String bloodGroup);
//    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
//}
