package com.example.redcrosshackthon.domain.bloodCertificate.repository;

import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodCertificateRepository extends JpaRepository<BloodCertificate,Long> {
}
