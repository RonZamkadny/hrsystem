package com.ronx.hr.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Column(name = "date_of_hire", nullable = true)
    private Date dateOfHire;

    @Column(name = "manager_id", nullable = false)
    private int managerId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Position.class)
    private Position position;

}
