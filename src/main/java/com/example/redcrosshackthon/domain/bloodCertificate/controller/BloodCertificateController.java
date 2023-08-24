package com.example.redcrosshackthon.domain.bloodCertificate.controller;

import com.example.redcrosshackthon.domain.bloodCertificate.dto.request.BloodCertificateRegisterReqDto;
import com.example.redcrosshackthon.domain.bloodCertificate.dto.response.BloodCertificateRegisterResDto;
import com.example.redcrosshackthon.domain.bloodCertificate.service.BloodCertificateService;
import com.example.redcrosshackthon.global.response.ResultCode;
import com.example.redcrosshackthon.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blood_certificate")
public class BloodCertificateController {

    private final BloodCertificateService bloodCertificateService;
    @PostMapping
    public ResponseEntity<BloodCertificateRegisterResDto> register(@RequestBody BloodCertificateRegisterReqDto bloodCertificateRegisterReqDto){
        BloodCertificateRegisterResDto register = bloodCertificateService.register(bloodCertificateRegisterReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);


    }
}
