package com.spring.healthcare.controller;

import com.spring.healthcare.data.Admin;
import com.spring.healthcare.model.CreateAdminRequest;
import com.spring.healthcare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping()
    public Admin createAdmin(@RequestBody CreateAdminRequest req) {
        return adminService.createAdmin(req);
    }

}
