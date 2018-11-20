package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }
    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        return user;

    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
