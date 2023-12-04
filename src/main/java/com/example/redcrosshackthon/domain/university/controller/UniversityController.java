package com.example.redcrosshackthon.domain.university.controller;

import com.example.redcrosshackthon.domain.university.dto.request.UniversityRegisterRequestDto;
import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.university.service.UniversityService;
import com.example.redcrosshackthon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    @PostMapping("/register")
    public ResponseEntity<Long> registerUniversity(@RequestBody UniversityRegisterRequestDto universityRegisterRequestDto){
        University university = new University(universityRegisterRequestDto.getUniversityName());
        Long getUniversityId = universityService.createUniversity(university);
        return ResponseEntity.status(HttpStatus.OK).body(getUniversityId);
    }
}
