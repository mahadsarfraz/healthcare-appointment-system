package com.spring.Healthcare.model;

import com.spring.Healthcare.enums.Userenum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "admins")
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    private String department;
    private String position;

    public Admin(String name, String email, String password, String phoneNumber, String department, String position) {
        super(null, name, email, password, phoneNumber, Userenum.UserRole.ADMIN);
        this.department = department;
        this.position = position;
    }
}
