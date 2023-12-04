package com.example.redcrosshackthon.domain.bloodCertificate.controller;

import com.example.redcrosshackthon.domain.bloodCertificate.dto.request.BloodCertificateRegisterReqDto;
import com.example.redcrosshackthon.domain.bloodCertificate.dto.response.BloodCertificateResDto;
import com.example.redcrosshackthon.domain.bloodCertificate.service.BloodCertificateService;
import com.example.redcrosshackthon.global.response.ResultCode;
import com.example.redcrosshackthon.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blood_certificate")
public class BloodCertificateController {

    private final BloodCertificateService bloodCertificateService;
    @PostMapping
    public ResponseEntity<ResultResponse> register(@RequestBody BloodCertificateRegisterReqDto bloodCertificateRegisterReqDto){
        //if bloodCertificateRegisterReqDto.getBloodInfo() //존재하는 헌혈증서 에러처리하기
        bloodCertificateService.register(bloodCertificateRegisterReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResultResponse.of(ResultCode.BloodCertificate_REGISTER_SUCCESS));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BloodCertificateResDto>> getBloodCertificate(@PathVariable Long userId){
        List<BloodCertificateResDto> bloodCertificate = bloodCertificateService.findBloodCertificate(userId);
        return ResponseEntity.status(HttpStatus.OK).body(bloodCertificate);
    }
}
