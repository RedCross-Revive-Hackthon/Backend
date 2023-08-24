package com.example.redcrosshackthon.domain.score.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScoreRegisterReqDto {
    private Long user_id;
    private int point;
    private String type;
}
