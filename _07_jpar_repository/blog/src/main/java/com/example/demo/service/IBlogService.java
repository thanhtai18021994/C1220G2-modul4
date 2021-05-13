package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> search();
    Blog findById(Integer id);
    void save(Blog blog);
}
