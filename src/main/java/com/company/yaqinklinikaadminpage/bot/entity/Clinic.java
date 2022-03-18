package com.company.yaqinklinikaadminpage.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {
    private String name;
    private String address;
    private String phone;
    private String time;
    private Integer districtId;
    private boolean c_type;
    private String c_arentr;
    private String c_karta;
    private Integer c_Reyting;



}
