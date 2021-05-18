package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    public List<User> findAll(){
      return userRepository.findAll();
    }
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
    public void save(User user){
        userRepository.save(user);
    }
    public User saveR(User user){
        return userRepository.save(user);
    }
    public void delete(User user){
        userRepository.delete(user);
    }
}
