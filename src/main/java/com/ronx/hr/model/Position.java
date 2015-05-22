package com.ronx.hr.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

}
