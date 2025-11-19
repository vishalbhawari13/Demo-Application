package com.example.demoapplication.service;

import com.example.demoapplication.entity.User;
import com.example.demoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    //CREATE
    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    //FindAll
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }


    //GetById
    public User getUserById(Long id)
    {
       return  userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }


    //UpdateUserbYId
    public User updateUser(Long id,User userDetails)
    {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());

       return userRepository.save(user);

    }

    //DeleteUser
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
}

