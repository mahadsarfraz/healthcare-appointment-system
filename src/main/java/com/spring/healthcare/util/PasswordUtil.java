package com.spring.healthcare.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    // Method to hash a password using BCrypt
    public static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
}

