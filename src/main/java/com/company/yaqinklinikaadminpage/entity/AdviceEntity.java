package com.company.yaqinklinikaadminpage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "maslahat")
public class AdviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer a_id;
    private String a_name;
    private Integer a_c_id;
    private String lan;
}
