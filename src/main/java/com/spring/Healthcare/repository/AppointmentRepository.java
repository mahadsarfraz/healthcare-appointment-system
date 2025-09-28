package com.spring.Healthcare.repository;

import com.spring.Healthcare.model.Appointment;
import com.spring.Healthcare.model.AppointmentStatus;
import com.spring.Healthcare.model.Doctor;
import com.spring.Healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByStatus(AppointmentStatus status);
    List<Appointment> findByDoctorAndAppointmentDateTimeBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
    List<Appointment> findByPatientAndAppointmentDateTimeBetween(Patient patient, LocalDateTime start, LocalDateTime end);
}
