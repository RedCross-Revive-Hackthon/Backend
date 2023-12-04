package com.example.redcrosshackthon.domain.score.dto.response;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ScoresUserInfoResDto {
    private Long userId;
    private List<ScoreInfoResDto> scores;
}
