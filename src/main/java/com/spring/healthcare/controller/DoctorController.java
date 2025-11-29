package com.spring.healthcare.controller;

import com.spring.healthcare.model.CreateDoctorRequest;
import com.spring.healthcare.model.DoctorResponse;
import com.spring.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public DoctorResponse createDoctor(@RequestBody CreateDoctorRequest doctorRequest) {
        return doctorService.createDoctor(doctorRequest);
    }
}
