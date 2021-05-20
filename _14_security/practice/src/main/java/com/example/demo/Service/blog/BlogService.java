package com.example.demo.Service.blog;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
      return blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
       blogRepository.delete(blog);
    }

    @Override
    public Blog saveR(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> filter(String text) {
        return blogRepository.findByTitleContaining(text);
    }
}
