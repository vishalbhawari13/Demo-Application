package com.example.demoapplication.service;

import com.example.demoapplication.dto.UserDTO;
import com.example.demoapplication.entity.User;
import com.example.demoapplication.exception.ResourceNotFoundException;
import com.example.demoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "users",key = "#id")
    public User getUserById(Long id)
    {
       return  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"+id));
    }


    //UpdateUserbYId
    @CachePut(value = "users",key = "#id")
    public User updateUser(Long id,UserDTO userDTO)
    {
        User existingUser = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found"+id));

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAge(userDTO.getAge());

       return userRepository.save(existingUser);

    }

    //DeleteUser
    @CacheEvict(value = "users",key = "#id")
    public void deleteUser(Long id)
    {
        if(!userRepository.existsById(id))
        {
            throw new ResourceNotFoundException("User not found with id "+id);
        }
        userRepository.deleteById(id);
    }
}

