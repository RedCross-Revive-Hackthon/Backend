package com.example.redcrosshackthon.domain.bloodCertificate.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BloodCertificateResDto {
    private Long userId;
    private String bloodInfo;

}
