package com.example.redcrosshackthon.domain.university.service;

import com.example.redcrosshackthon.domain.university.dto.request.UniversityRegisterRequestDto;
import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;

    public Long createUniversity(University university){
        University saveUniversity = universityRepository.save(university);
        return saveUniversity.getId();
    }
    public University getUniversity(Long univId){
        Optional<University> getUniversity = universityRepository.findById(univId);
        return getUniversity.get();
    }

}
