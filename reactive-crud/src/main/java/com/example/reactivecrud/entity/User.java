package com.example.reactivecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Data
@Table("Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
