package com.example.redcrosshackthon.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_id;

    private String pwd;

    private String name;

    private String email;

    private String department;

    private String image;

    @Builder
    public User(String user_id, String pwd, String name, String email, String department) {
        this.user_id = user_id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.department = department;
    }
}