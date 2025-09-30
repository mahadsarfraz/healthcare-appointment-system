package com.spring.Healthcare.service;

import com.spring.Healthcare.data.Admin;
import com.spring.Healthcare.model.CreateAdminRequest;
import com.spring.Healthcare.repository.AdminRepository;
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
        Admin newAdmin = new Admin(req.username, req.password);
        return adminRepository.save(newAdmin);
    }
}
