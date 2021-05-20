package com.example.demo.dto;

public class BlogDto {
    private String title;
    private String content;
    private String date;
    private String image;
    private Integer idCategory;

    public BlogDto() {
    }

    public BlogDto(String title, String content, String date, String image, Integer idCategory) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.idCategory = idCategory;
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

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}
