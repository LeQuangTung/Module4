package com.example.testmodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
