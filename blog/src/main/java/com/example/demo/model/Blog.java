package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer id;
    private String title;
    @Column(columnDefinition = "longtext")
    private String content;
    @Column(columnDefinition = "date")
    private String date;
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_category",nullable = false)
    private Category category;

    public Blog() {
    }

    public Blog(String title, String content, String date, String image, Category category) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.category = category;
    }

    public Blog(Integer id, String title, String content, String date, String image, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
