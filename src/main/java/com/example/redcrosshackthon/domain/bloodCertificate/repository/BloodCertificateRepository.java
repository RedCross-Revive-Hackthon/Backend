package com.example.redcrosshackthon.domain.bloodCertificate.repository;

import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodCertificateRepository extends JpaRepository<BloodCertificate,Long> {
    List<BloodCertificate> findByUser_Id(Long userId);
}
