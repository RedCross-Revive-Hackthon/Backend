package com.example.redcrosshackthon.domain.score.entity;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "score")
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int point;

    private String type;

    @CreatedDate
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Score(int point, String type, LocalDate created_at, User user) {
        this.point = point;
        this.type = type;
        this.user = user;
    }
}
