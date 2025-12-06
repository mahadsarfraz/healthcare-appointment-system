package com.spring.healthcare.service;

import com.spring.healthcare.data.Patient;
import com.spring.healthcare.model.PatientResponse;
import com.spring.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponse> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientResponse::mapToPatientResponse)
                .toList();

    }
}
