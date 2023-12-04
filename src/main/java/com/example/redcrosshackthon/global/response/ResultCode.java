package com.example.redcrosshackthon.global.response;

import com.example.redcrosshackthon.domain.bloodCertificate.entity.BloodCertificate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    //Score
    SCORE_REGISTER_SUCCESS("S001","점수 등록 완료"),
    BloodCertificate_REGISTER_SUCCESS("S002","헌혈증서 등록 완료");

    private final String code;
    private final String message;
}
