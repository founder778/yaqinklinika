package com.company.yaqinklinikaadminpage.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Button {
    private Integer id;
    private String name;
    private String data;
    private Integer menu_id;
}
