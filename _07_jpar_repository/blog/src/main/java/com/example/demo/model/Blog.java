package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private String dateSubmit;
    private String content;

    public Blog() {
    }

    public Blog(String title, String image, String dateSubmit, String content) {
        this.title = title;
        this.image = image;
        this.dateSubmit = dateSubmit;
        this.content = content;
    }

    public Blog(Integer id, String title, String image, String dateSubmit, String content) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.dateSubmit = dateSubmit;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
