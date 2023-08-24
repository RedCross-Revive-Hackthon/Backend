package com.example.redcrosshackthon.domain.bloodCertificate.dto.response;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BloodCertificateRegisterResDto {
    private User user;
    private String bloodInfo;

}
