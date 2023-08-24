package com.example.redcrosshackthon.domain.bloodCertificate.service;

import com.example.redcrosshackthon.domain.bloodCertificate.dto.request.BloodCertificateRegisterReqDto;
import com.example.redcrosshackthon.domain.bloodCertificate.dto.response.BloodCertificateRegisterResDto;
import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import com.example.redcrosshackthon.domain.bloodCertificate.repository.BloodCertificateRepository;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import com.example.redcrosshackthon.global.error.ErrorCode;
import com.example.redcrosshackthon.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;

@Service
@RequiredArgsConstructor
public class BloodCertificateService {
    private final BloodCertificateRepository bloodCertificateRepository;
    private final UserRepository userRepository;

    @Transactional
    public BloodCertificateRegisterResDto register(BloodCertificateRegisterReqDto bloodCertificateRegisterReqDto) {
        User findUser = userRepository.findById(bloodCertificateRegisterReqDto.getUserId()).orElseThrow(() -> new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        BloodCertificate certificate = BloodCertificate.builder()
                .bloodInfo(bloodCertificateRegisterReqDto.getBloodInfo())
                .user(findUser)
                .build();
        bloodCertificateRepository.save(certificate);
        return builder(certificate);
    }
    private BloodCertificateRegisterResDto builder(BloodCertificate bloodCertificate){
        return BloodCertificateRegisterResDto.builder()
                .user(bloodCertificate.getUser())
                .bloodInfo(bloodCertificate.getBloodInfo())
                .build();
    }
}
