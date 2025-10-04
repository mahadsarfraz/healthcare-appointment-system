package com.spring.healthcare.model;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminRequest {
    private String username;
    private String password;

}
