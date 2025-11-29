package com.spring.healthcare.controller;

import com.spring.healthcare.model.CreateDoctorRequest;
import com.spring.healthcare.model.DoctorResponse;
import com.spring.healthcare.model.UpdateDoctorRequest;
import com.spring.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorResponse getDoctorById(@PathVariable Integer id) {
        return doctorService.findDoctorById(id);
    }

    @PostMapping()
    public DoctorResponse createDoctor(@RequestBody CreateDoctorRequest doctorRequest) {
        return doctorService.createDoctor(doctorRequest);
    }

    @PatchMapping("/{id}")
    public DoctorResponse updateDoctor(@PathVariable Integer id, @RequestBody UpdateDoctorRequest req) {
        return doctorService.updateDoctorProfile(id, req);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        return doctorService.deleteDoctor(id);
    }
}
