package com.spring.healthcare.controller;

import com.spring.healthcare.model.PatientResponse;
import com.spring.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}