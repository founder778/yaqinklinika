package com.company.yaqinklinikaadminpage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "intencive")
public class IntenciveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer a_id;
    private String a_name;
    private String a_type;
    private Integer a_c_id;
    private String lan;
}
