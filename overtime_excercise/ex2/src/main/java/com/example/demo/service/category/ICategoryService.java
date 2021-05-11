package com.example.demo.service.category;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ICategoryService implements CaregoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Integer num1) {
        Page<Category> categories=categoryRepository.findAll(PageRequest.of(0,num1, Sort.by("name").descending()));
        return categories;
    }

    @Override
    public List<Category> search(String text,Integer num1,Integer num2) {
        Pageable pageable= (Pageable) PageRequest.of(num1,num2,Sort.by("name"));
        return categoryRepository.findAllByNameContaining(text, pageable);
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void save(Category object) {

    }

    @Override
    public void delete(Category object) {

    }
}
