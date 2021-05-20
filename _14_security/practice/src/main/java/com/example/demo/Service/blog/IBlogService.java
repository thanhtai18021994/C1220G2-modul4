package com.example.demo.Service.blog;

import com.example.demo.Service.IGeneralService;
import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> filter(String text);
}
