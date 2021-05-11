package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO);
    private Integer id;
    private String name;
    private String context;
    private String img;
}
