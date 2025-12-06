package com.spring.healthcare.controller;

import com.spring.healthcare.model.CreatePatientRequest;
import com.spring.healthcare.model.PatientResponse;
import com.spring.healthcare.model.UpdatePatientRequest;
import com.spring.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public List<PatientResponse> findAll() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public PatientResponse findById(@PathVariable Integer id) {
        return patientService.findPatientById(id);
    }

    @PostMapping()
    public PatientResponse createPatient(@RequestBody CreatePatientRequest req) {
        return patientService.createPatient(req);
    }

    @PatchMapping("/{id}")
    public PatientResponse updatePatient(@PathVariable Integer id, @RequestBody UpdatePatientRequest req) {
        return patientService.updatePatientProfile(id, req);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Integer id) {
       return patientService.deletePatient(id);
    }

}