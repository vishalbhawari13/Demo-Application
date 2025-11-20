package com.example.demoapplication.controller;

import com.example.demoapplication.dto.UserDTO;
import com.example.demoapplication.entity.User;
import com.example.demoapplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Demo")
public class UserController {

    @Autowired
    private UserService userService;


    //create user
    @PostMapping("/add")
    public User addUser(@Valid @RequestBody UserDTO  userDTO)
    {
        return userService.createUser(userDTO);
    }

    //find all user
    @GetMapping("/findAll")
    public List<User> getAlluser()
    {
        return userService.getAllUsers();
    }


    //find single user by id
    @GetMapping("/find/{id}")
    public User findById(@PathVariable Long id)
    {
       return userService.getUserById(id);
    }

    //update user by id
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,@Valid @RequestBody UserDTO  userDTO)
    {
        return userService.updateUser(id,userDTO);
    }

    //delete user by id
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }


}
