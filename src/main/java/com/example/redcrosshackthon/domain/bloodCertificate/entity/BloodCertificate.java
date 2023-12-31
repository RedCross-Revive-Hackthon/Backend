package com.example.redcrosshackthon.domain.bloodCertificate.entity;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "bloodCertificate")
@RequiredArgsConstructor
public class BloodCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloodCertificate_id")
    private Long id;

    private String bloodInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public BloodCertificate(User user, String bloodInfo) {
        this.user = user;
        this.bloodInfo = bloodInfo;
    }
}
