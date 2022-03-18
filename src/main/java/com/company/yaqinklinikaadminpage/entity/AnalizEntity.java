package com.company.yaqinklinikaadminpage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "analiz")
public class AnalizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer a_id;
    private String a_name;
    private String a_type;
    private Integer a_c_id;
    private String lan;
}
