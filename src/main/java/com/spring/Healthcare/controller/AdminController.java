package com.spring.Healthcare.controller;

import com.spring.Healthcare.data.Admin;
import com.spring.Healthcare.model.CreateAdminRequest;
import com.spring.Healthcare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping()
    public Admin createAdmin(CreateAdminRequest req) {
        return adminService.createAdmin(req);
    }

}
