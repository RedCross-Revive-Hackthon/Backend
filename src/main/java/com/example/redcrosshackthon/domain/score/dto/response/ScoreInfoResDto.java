package com.example.redcrosshackthon.domain.score.dto.response;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScoreInfoResDto {
    private int point;
    private String type;
}
