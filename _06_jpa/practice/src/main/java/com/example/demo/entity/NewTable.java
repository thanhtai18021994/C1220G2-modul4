package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newtable")
public class NewTable {
    @Id
    @GeneratedValue()
    private String name;
    private Long count;


    public NewTable(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public NewTable() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
