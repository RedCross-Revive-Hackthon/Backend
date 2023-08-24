package com.example.redcrosshackthon.domain.university.repository;

import com.example.redcrosshackthon.domain.university.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
