package com.example.ManagerShoers.dao.entity;

import com.example.ManagerShoers.common.Constans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    @Column(name = "token")
    private String token;

    public Account(String username, String password, String phone, String mail, String role) {
    }
}
