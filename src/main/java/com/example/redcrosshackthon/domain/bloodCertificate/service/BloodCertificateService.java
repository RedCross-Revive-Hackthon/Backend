package com.example.redcrosshackthon.domain.bloodCertificate.service;

import com.example.redcrosshackthon.domain.bloodCertificate.dto.request.BloodCertificateRegisterReqDto;
import com.example.redcrosshackthon.domain.bloodCertificate.dto.response.BloodCertificateResDto;
import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import com.example.redcrosshackthon.domain.bloodCertificate.repository.BloodCertificateRepository;
import com.example.redcrosshackthon.domain.score.dto.request.ScoreRegisterReqDto;
import com.example.redcrosshackthon.domain.score.service.ScoreService;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import com.example.redcrosshackthon.global.error.ErrorCode;
import com.example.redcrosshackthon.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BloodCertificateService {
    private static final int BLOOD_CERTIFICATE_POINT = 400;
    private final BloodCertificateRepository bloodCertificateRepository;
    private final UserRepository userRepository;
    private final ScoreService scoreService;

    @Transactional
    public void register(BloodCertificateRegisterReqDto bloodCertificateRegisterReqDto) {
        User findUser = userRepository.findById(bloodCertificateRegisterReqDto.getUserId()).orElseThrow(() -> new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        BloodCertificate certificate = new BloodCertificate(findUser, bloodCertificateRegisterReqDto.getBloodInfo());
        bloodCertificateRepository.save(certificate);
        scoreService.registerScore(BloodCertificateScore(bloodCertificateRegisterReqDto.getUserId()));
    }

    private ScoreRegisterReqDto BloodCertificateScore(Long userId){
        return ScoreRegisterReqDto.builder()
                .user_id(userId)
                .point(BLOOD_CERTIFICATE_POINT)
                .type("헌혈증서 등록")
                .build();
    }

    public List<BloodCertificateResDto> findBloodCertificate(Long userId) {
        List<BloodCertificate> certificates = bloodCertificateRepository.findByUser_Id(userId);
        List<BloodCertificateResDto> result = buildBloodCertificateResDto(userId, certificates);
        return result;
    }

    private List<BloodCertificateResDto> buildBloodCertificateResDto(Long userId, List<BloodCertificate> certificates) {
        List<BloodCertificateResDto> result = certificates.stream().map(certificate -> BloodCertificateResDto.builder()
                .userId(userId)
                .bloodInfo(certificate.getBloodInfo())
                .build()
        ).collect(Collectors.toList());
        return result;
    }
}
