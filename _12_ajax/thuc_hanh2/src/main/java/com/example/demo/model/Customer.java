package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;
    private String copyRightBy;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer age, Double salary, String copyRightBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.copyRightBy = copyRightBy;
    }

    public Customer(Integer id, String firstName, String lastName, Integer age, Double salary, String copyRightBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.copyRightBy = copyRightBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCopyRightBy() {
        return copyRightBy;
    }

    public void setCopyRightBy(String copyRightBy) {
        this.copyRightBy = copyRightBy;
    }
}
