package com.spring.healthcare.service;

import com.spring.healthcare.data.Admin;
import com.spring.healthcare.exception.BadRequestException;
import com.spring.healthcare.exception.DataValidationException;
import com.spring.healthcare.model.AdminResponse;
import com.spring.healthcare.model.CreateAdminRequest;
import com.spring.healthcare.model.UpdateAdminReq;
import com.spring.healthcare.repository.AdminRepository;
import com.spring.healthcare.util.PasswordUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminResponse> findAll(){
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(admin -> new AdminResponse(admin.getId(), admin.getUsername()))
                .toList();
    }

    public AdminResponse findAdminById(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new AdminResponse(admin.getId(), admin.getUsername());
    }

    public AdminResponse createAdmin(CreateAdminRequest req) {
        if(req.getUsername() == null || req.getPassword() == null) {
            throw new BadRequestException("Username and Password must not be null");
        }

        if(isAdminExists(req.getUsername())) {
            throw new DataValidationException("Admin with username " + req.getUsername() +  " already exists");
        }

        if(!PasswordUtil.isPasswordValid(req.getPassword())) {
            throw new DataValidationException("Password length must be at least 6 characters");
        }
        // Hashing password
        String hashedPassword = PasswordUtil.hashPassword(req.getPassword());
        Admin admin = new Admin(req.getUsername(), hashedPassword);
        Admin savedAdmin = adminRepository.save(admin);
        return new AdminResponse(savedAdmin.getId(), savedAdmin.getUsername());
    }

    public AdminResponse updateAdmin(Integer id, UpdateAdminReq req) {
        Admin admin = adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (req.getPassword() != null && !req.getPassword().isEmpty()) {

            if (!PasswordUtil.isPasswordValid(req.getPassword())) {
                throw new DataValidationException("Password length must be at least 6 characters");
            }
            String hashedPassword = PasswordUtil.hashPassword(req.getPassword());
            admin.setPassword(hashedPassword);
            admin = adminRepository.save(admin);
            return new AdminResponse(admin.getId(), admin.getUsername());
        } else {
            throw new IllegalArgumentException("Password must not be null or empty");
        }
    }

    public String deleteAdmin(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        adminRepository.delete(admin);
        return "Admin with ID " + id + " has been deleted.";
    }

    private boolean isAdminExists(String username) {
        return adminRepository.existsByUsername(username);
    }
}
