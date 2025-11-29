package com.spring.healthcare.service;

import com.spring.healthcare.data.Doctor;
import com.spring.healthcare.exception.DataValidationException;
import com.spring.healthcare.model.CreateDoctorRequest;
import com.spring.healthcare.model.DoctorResponse;
import com.spring.healthcare.repository.DoctorRepository;
import com.spring.healthcare.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorResponse createDoctor(CreateDoctorRequest req) {
        if (doctorExistsByEmail(req.getEmail())) {
            throw new DataValidationException("Doctor with this email already exists");
        }

        if (!PasswordUtil.isPasswordValid(req.getPassword())) {
            throw new DataValidationException("Password length must be at least 6 characters");
        }

        // Hashing password
        String hashedPassword = PasswordUtil.hashPassword(req.getPassword());

        // Creating Doctor entity
        Doctor doctor = new Doctor();
        doctor.setFirstName(req.getFirstName());
        doctor.setLastName(req.getLastName());
        doctor.setEmail(req.getEmail());
        doctor.setPassword(hashedPassword);
        doctor.setPhoneNumber(req.getPhoneNumber());
        doctor.setSpecialization(req.getSpecialization());
        doctor.setLicenseNumber(req.getLicenseNumber());
        doctor.setYearsOfExperience(req.getYearsOfExperience());
        doctor.setQualification(req.getQualification());
        doctor.setConsultationFee(req.getConsultationFee());
        Doctor savedDoctor = doctorRepository.save(doctor);

        return CreateDoctorRequest.mapToDocResponse(savedDoctor);
    }

    private boolean doctorExistsByEmail(String email) {
        return doctorRepository.existsByEmail(email);
    }
}
