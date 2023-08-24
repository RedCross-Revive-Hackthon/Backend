package com.example.redcrosshackthon.domain.user.repository;

import com.example.redcrosshackthon.domain.user.dto.response.RankUserResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u join u.scores s group by u.id ORDER BY SUM(s.point) DESC")
    List<User> getTop3UsersByTotalPoint();
    @Query("SELECT u from User u join u.scores s group by u.id ORDER BY SUM(s.point) DESC")
    List<User> getUsersByTotalPoint();
}