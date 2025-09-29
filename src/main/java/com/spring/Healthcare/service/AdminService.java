package com.spring.Healthcare.service;

import com.spring.Healthcare.data.Admin;
import com.spring.Healthcare.data.User;
import com.spring.Healthcare.model.AdminResponse;
import com.spring.Healthcare.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin findAdminById(Integer id) {
        return  adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + id));


    }
}
