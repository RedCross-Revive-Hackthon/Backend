package com.example.redcrosshackthon.domain.user.repository;

import com.example.redcrosshackthon.domain.user.dto.response.RankUserResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u join u.scores")
    List<RankUserResDto> getUserScores();
}