package com.example.testmodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Integer age;
    private Double salary;
    @ManyToOne
    private Branch branch;
}
