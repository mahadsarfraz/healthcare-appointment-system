package com.spring.healthcare.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminRequest {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
