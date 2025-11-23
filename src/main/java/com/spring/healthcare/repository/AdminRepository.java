package com.spring.healthcare.repository;

import com.spring.healthcare.data.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    boolean existsByUsername(String username);

}
