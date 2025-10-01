package com.spring.healthcare.service;

import com.spring.healthcare.data.Admin;
import com.spring.healthcare.model.CreateAdminRequest;
import com.spring.healthcare.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Admin findAdminById(Integer id) {
        return adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Admin createAdmin(CreateAdminRequest req) {
        Admin newAdmin = new Admin(req.getUsername(), req.getPassword());
        return adminRepository.save(newAdmin);
    }
}
