package com.example.redcrosshackthon.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Global
    INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
    INPUT_INVALID_ERROR(400, "G002", "잘못된 입력"),

    //User
    USER_NOT_FOUND(404,"U001","유저를 찾을 수 없습니다."),

    //University
    UNIVERSITY_NOT_FOUND(404,"UN001","대학을 찾을 수 없습니다."),
    //Blood
    BLOOD_CERTIFICATE_NOT_FOUND(404,"B001","헌혈증서가 없습니다.");



    private final int status;
    private final String code;
    private final String message;

}
