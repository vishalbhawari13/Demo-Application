package com.example.demoapplication.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "email is required")
    private String email;

    @Min(value = 18,message = "Age must be atleast 18")
    private int age;
}
