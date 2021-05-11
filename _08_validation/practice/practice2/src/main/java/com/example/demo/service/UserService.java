package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.reposiotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    public boolean checkName(String name){
        List<User> list=userRepository.findAll();
        for (User user:list){
            if(user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
