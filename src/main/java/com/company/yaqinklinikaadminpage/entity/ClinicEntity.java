package com.company.yaqinklinikaadminpage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "clinc")
public class ClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;
    private String c_name;
    private String c_address;
    private String c_phone;
    private Integer c_d_id;
    private String c_type;
    private String c_arentr;
    private String c_karta;
    private String c_time;
    private Integer c_reyting;
}
