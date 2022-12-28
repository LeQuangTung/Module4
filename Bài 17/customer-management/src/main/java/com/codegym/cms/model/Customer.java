package com.codegym.cms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return String.format("Customer[id=%d, name='%s', age=%d]", id, name, age);
    }
}
