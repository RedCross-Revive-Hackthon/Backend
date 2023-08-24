package com.example.redcrosshackthon.global.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultResponse {

    private String code;
    private String message;

    public static ResultResponse of(ResultCode resultCode){
        return new ResultResponse(resultCode);
    }

    public ResultResponse(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

}
