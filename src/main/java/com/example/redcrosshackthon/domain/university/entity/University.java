package com.example.redcrosshackthon.domain.university.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "university")
@RequiredArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long id;

    private String univName;

    public University(String univName) {
        this.univName = univName;
    }
}
