package com.spring.healthcare.data;

import com.spring.healthcare.enums.Userenum;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Userenum.UserRole role = Userenum.UserRole.ADMIN;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = Userenum.UserRole.ADMIN;
    }
}
