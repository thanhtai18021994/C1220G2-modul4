package com.codegym.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacture")
public class Manufacture {
    private Integer id;
    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    public Manufacture(String name) {
        this.name = name;
    }

    public Manufacture() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
