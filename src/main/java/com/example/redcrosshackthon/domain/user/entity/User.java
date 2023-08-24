package com.example.redcrosshackthon.domain.user.entity;

import com.example.redcrosshackthon.domain.score.entity.Score;
import com.example.redcrosshackthon.domain.university.entity.University;
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

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "user")
    private List<Score> scores;

}