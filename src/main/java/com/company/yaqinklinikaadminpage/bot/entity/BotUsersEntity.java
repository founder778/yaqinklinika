package com.company.yaqinklinikaadminpage.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "botusers")
public class BotUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;

    public BotUsersEntity(String userId) {
        this.userId = userId;
    }
}
