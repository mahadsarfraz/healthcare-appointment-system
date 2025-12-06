package com.spring.healthcare.service;

import com.spring.healthcare.data.Patient;
import com.spring.healthcare.enums.Userenum;
import com.spring.healthcare.exception.DataValidationException;
import com.spring.healthcare.model.CreatePatientRequest;
import com.spring.healthcare.model.PatientResponse;
import com.spring.healthcare.model.UpdatePatientRequest;
import com.spring.healthcare.repository.PatientRepository;
import com.spring.healthcare.util.PasswordUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponse> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientResponse::mapToPatientResponse)
                .toList();

    }

    public PatientResponse findPatientById(Integer id) {
        Patient patient = patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return PatientResponse.mapToPatientResponse(patient);
    }

    public PatientResponse createPatient(CreatePatientRequest req) {
        if(patientRepository.existsByEmail(req.getEmail())) {
            throw new DataValidationException("Patient with this email already exists");
        }

        if(!PasswordUtil.isPasswordValid(req.getPassword())) {
            throw new DataValidationException("Password length must be at least 6 characters");
        }

        // Hashing password
        String hashedPassword = PasswordUtil.hashPassword(req.getPassword());

        // Creating Patient entity
        Patient patient = new Patient();
        patient.setFirstName(req.getFirstName());
        patient.setLastName(req.getLastName());
        patient.setEmail(req.getEmail());
        patient.setPassword(hashedPassword);
        patient.setPhoneNumber(req.getPhoneNumber());
        patient.setRole(Userenum.UserRole.PATIENT);
        patient.setDateOfBirth(req.getDateOfBirth());
        patient.setBloodGroup(req.getBloodGroup());
        patient.setMedicalHistory(req.getMedicalHistory());
        patient.setAllergies(req.getAllergies());

        Patient savedPatient = patientRepository.save(patient);
        return PatientResponse.mapToPatientResponse(savedPatient);
    }

    public PatientResponse updatePatientProfile(Integer id, UpdatePatientRequest req) {
        Patient patient = patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(req.getFirstName() != null) {
            patient.setFirstName(req.getFirstName());
        }
        if(req.getLastName() != null) {
            patient.setLastName(req.getLastName());
        }
        if(req.getPhoneNumber() != null) {
            patient.setPhoneNumber(req.getPhoneNumber());
        }
        if(req.getDateOfBirth() != null) {
            patient.setDateOfBirth(req.getDateOfBirth());
        }
        if(req.getBloodGroup() != null) {
            patient.setBloodGroup(req.getBloodGroup());
        }
        if(req.getMedicalHistory() != null) {
            patient.setMedicalHistory(req.getMedicalHistory());
        }
        if(req.getAllergies() != null) {
            patient.setAllergies(req.getAllergies());
        }

        Patient updatedPatient = patientRepository.save(patient);
        return PatientResponse.mapToPatientResponse(updatedPatient);
    }

    public String deletePatient(Integer id) {
        Patient patient = patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        patientRepository.delete(patient);
        return "Patient with ID " + id + " has been deleted.";
    }
}
