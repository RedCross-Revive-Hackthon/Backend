package com.example.redcrosshackthon.domain.user.entity;

import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import com.example.redcrosshackthon.domain.score.entity.Score;
import com.example.redcrosshackthon.domain.university.entity.University;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String identity;

    private String pwd;

    private String name;

    private String email;

    private String department;

    @Column(columnDefinition = "int default 0")
    private int point;

    private String image;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "user")
    private List<Score> scores;

    @OneToMany(mappedBy = "user")
    private List<BloodCertificate> bloodCertificates;

    public User(String identity, String pwd, String name, String email, String department) {
        this.identity = identity;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    public void setUniversity(University university){
        this.university = university;
    }
    public void setPoint(int count){
        this.point += count;
    }
}
