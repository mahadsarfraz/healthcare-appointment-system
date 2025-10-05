package com.spring.healthcare.controller;

import com.spring.healthcare.data.Admin;
import com.spring.healthcare.model.AdminResponse;
import com.spring.healthcare.model.CreateAdminRequest;
import com.spring.healthcare.model.UpdateAdminReq;
import com.spring.healthcare.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping()
    public List<AdminResponse> getAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public AdminResponse getAdminById(@Valid @PathVariable Integer id) {
        return adminService.findAdminById(id);
    }

    @PostMapping()
    public AdminResponse createAdmin(@RequestBody @Valid CreateAdminRequest req) {
       return adminService.createAdmin(req);
    }

    @PatchMapping("/{id}")
    public AdminResponse updateAdmin(@PathVariable Integer id, @RequestBody @Valid UpdateAdminReq req) {
        return adminService.updateAdmin(id, req);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Integer id) {
        return adminService.deleteAdmin(id);
    }

}
