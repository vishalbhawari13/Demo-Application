package com.example.demoapplication.service;

import com.example.demoapplication.dto.UserDTO;
import com.example.demoapplication.entity.User;
import com.example.demoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    //CREATE -> Accept DTO
    public User createUser(UserDTO userDTO)
    {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());

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
    public User updateUser(Long id,UserDTO userDTO)
    {
        User existingUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAge(userDTO.getAge());

       return userRepository.save(existingUser);

    }

    //DeleteUser
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
}

