package com.example.redcrosshackthon.domain.score.dto.response;

import com.example.redcrosshackthon.domain.user.dto.response.RankUserResDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RankInfoResDto {
    private String UnivName;
    private List<RankUserResDto> userList;
}
