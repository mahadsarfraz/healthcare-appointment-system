package com.spring.Healthcare.model;

import lombok.Data;

@Data
public class CreateAdminRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String department;
    private String position;
}
