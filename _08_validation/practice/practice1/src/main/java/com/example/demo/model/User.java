package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "trong")
    @Size(min = 2,max = 20,message = "sai")
    private String name;

    @Min(18)
    private Integer age;

    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 20) String name, @Min(18) Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Integer id, @NotEmpty @Size(min = 2, max = 20) String name, @Min(18) Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
