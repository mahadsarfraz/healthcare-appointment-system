package com.spring.healthcare.service;

import com.spring.healthcare.data.Doctor;
import com.spring.healthcare.enums.Userenum;
import com.spring.healthcare.exception.DataValidationException;
import com.spring.healthcare.model.CreateDoctorRequest;
import com.spring.healthcare.model.DoctorResponse;
import com.spring.healthcare.model.UpdateDoctorRequest;
import com.spring.healthcare.repository.DoctorRepository;
import com.spring.healthcare.util.PasswordUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorResponse> findAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(DoctorResponse::mapToDocResponse)
                .toList();
    }

    public DoctorResponse findDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return DoctorResponse.mapToDocResponse(doctor);
    }

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
        doctor.setRole(Userenum.UserRole.DOCTOR);
        doctor.setSpecialization(req.getSpecialization());
        doctor.setLicenseNumber(req.getLicenseNumber());
        doctor.setYearsOfExperience(req.getYearsOfExperience());
        doctor.setQualification(req.getQualification());
        doctor.setConsultationFee(req.getConsultationFee());
        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorResponse.mapToDocResponse(savedDoctor);
    }

    public DoctorResponse updateDoctorProfile(Integer id, UpdateDoctorRequest req) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (req.getFirstName() != null) {
            doctor.setFirstName(req.getFirstName());
        }
        if (req.getLastName() != null) {
            doctor.setLastName(req.getLastName());
        }
        if (req.getPhoneNumber() != null) {
            doctor.setPhoneNumber(req.getPhoneNumber());
        }
        if (req.getSpecialization() != null) {
            doctor.setSpecialization(req.getSpecialization());
        }
        if (req.getYearsOfExperience() != null) {
            doctor.setYearsOfExperience(req.getYearsOfExperience());
        }
        if (req.getQualification() != null) {
            doctor.setQualification(req.getQualification());
        }

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return DoctorResponse.mapToDocResponse(updatedDoctor);
    }

    public String deleteDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        doctorRepository.delete(doctor);
        return "Doctor with ID " + id + " has been deleted.";
    }

    private boolean doctorExistsByEmail(String email) {
        return doctorRepository.existsByEmail(email);
    }
}
