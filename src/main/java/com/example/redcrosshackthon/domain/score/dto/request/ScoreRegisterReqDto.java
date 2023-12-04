package com.example.redcrosshackthon.domain.score.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ScoreRegisterReqDto {
    private Long user_id;
    private int point;
    private String type;

    public ScoreRegisterReqDto() {
    }
}
